package com.traveloka.hotel.component.form

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import java.util.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DateField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    placeholder: String,
    title: String
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    calendar.time = Date()
    val year = remember { mutableStateOf(calendar.get(Calendar.YEAR)) }
    val month = remember { mutableStateOf(calendar.get(Calendar.MONTH)) }
    val day = remember { mutableStateOf(calendar.get(Calendar.DAY_OF_MONTH)) }


    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, getYear: Int, getMonth: Int, getDayOfMonth: Int ->
            date.value = "$getYear-${(getMonth + 1).toString().padStart(2, '0')}-${
                getDayOfMonth.toString().padStart(2, '0')
            }"
            onValueChange(date.value)
            year.value = getYear
            month.value = getMonth
            day.value = getDayOfMonth
        }, year.value, month.value, day.value
    )

    datePickerDialog.datePicker.maxDate = System.currentTimeMillis()


    BaseField(
        enabled = false,
        onClick = { datePickerDialog.show() },
        modifier = modifier,
        value = date.value,
        onValueChange = { newDate -> onValueChange(newDate) },
        placeholder = placeholder,
        title = title,
        trailingIcon = {
            IconButton(onClick = { datePickerDialog.show() }) {
                Icon(
                    imageVector = Icons.Default.CalendarToday,
                    contentDescription = "date picker"
                )
            }
        }
    )

}