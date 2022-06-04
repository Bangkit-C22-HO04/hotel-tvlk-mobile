package com.traveloka.hotel.presentation.screens.login.components

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.R
import com.traveloka.hotel.presentation.navigation.HotelScreens
import com.traveloka.hotel.presentation.screens.login.LoginScreen
import com.traveloka.hotel.ui.theme.HotelmobileTheme
import com.traveloka.hotel.ui.widgets.button.MButton
import com.traveloka.hotel.ui.widgets.form.EmailField
import com.traveloka.hotel.ui.widgets.form.PasswordField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginForm(navController: NavController) {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

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
            title = stringResource(R.string.password),
            imeAction = ImeAction.Done,
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            })
        )


        MButton(
            modifier = Modifier.widthIn(min = 200.dp),
            text = stringResource(R.string.log_in),
            onClick = { navController.navigate(HotelScreens.ListHotelScreen.name) })
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginFormPreview() {
    HotelmobileTheme {
        LoginScreen(rememberNavController())
    }
}