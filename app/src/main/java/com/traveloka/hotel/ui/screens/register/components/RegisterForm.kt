package com.traveloka.hotel.ui.screens.register.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.traveloka.hotel.R
import com.traveloka.hotel.ui.widgets.button.MButton
import com.traveloka.hotel.ui.widgets.form.DateField
import com.traveloka.hotel.ui.widgets.form.EmailField
import com.traveloka.hotel.ui.widgets.form.PasswordField
import com.traveloka.hotel.ui.widgets.form.RadioField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterForm() {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }
    val options = listOf(stringResource(R.string.male), stringResource(R.string.female))
    val genderState = remember {
        mutableStateOf(options.first())
    }
    val dateState = remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        EmailField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            placeholder = stringResource(R.string.email_hint),
            title = stringResource(R.string.email)
        )
        PasswordField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            placeholder = stringResource(R.string.password_hint),
            title = stringResource(R.string.password)
        )
        PasswordField(
            value = confirmPasswordState.value,
            onValueChange = { confirmPasswordState.value = it },
            placeholder = stringResource(R.string.confirm_password_hint),
            title = stringResource(R.string.confirm_password),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            })
        )
        RadioField(
            title = stringResource(R.string.gender),
            options = options,
            selectedItem = genderState
        )
        DateField(
            onValueChange = { dateState.value = it },
            placeholder = "dd/mm/yyyy",
            title = stringResource(R.string.birth_date)
        )

        MButton(
            modifier = Modifier.widthIn(min = 200.dp),
            text = stringResource(R.string.register),
            onClick = {})
    }
}