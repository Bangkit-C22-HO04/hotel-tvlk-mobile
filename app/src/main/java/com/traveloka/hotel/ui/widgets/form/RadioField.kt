package com.traveloka.hotel.ui.widgets.form


import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.traveloka.hotel.ui.theme.Blue

@Composable
fun RadioField(
    title: String,
    options: List<String>,
    selectedItem: String,
    onValueChange: (String) -> Unit
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        FormTitle(title)
        RadioGroup(options, selectedItem, onValueChange)
    }
}

@Composable
fun RadioGroup(
    options: List<String>, selected: String, onValueChange: (String) -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Column {
        options.forEach {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) { onValueChange(it) }
            ) {
                RadioButton(
                    selected = it == selected,
                    onClick = { onValueChange(it) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Blue
                    )
                )
                Text(text = it, style = MaterialTheme.typography.body1)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewRadioButton() {
    val options = listOf("option 1", "option 2")
    val selectedItem = remember {
        mutableStateOf(options.first())
    }
    RadioField("title", options, selectedItem.value) { }
}
