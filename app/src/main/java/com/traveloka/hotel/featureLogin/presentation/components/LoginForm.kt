package com.traveloka.hotel.featureLogin.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.R
import com.traveloka.hotel.common.data.ResultApi
import com.traveloka.hotel.common.data.local.UserPreference
import com.traveloka.hotel.common.presentation.navigation.HotelScreens
import com.traveloka.hotel.common.presentation.screens.login.LoginScreen
import com.traveloka.hotel.component.button.MButton
import com.traveloka.hotel.component.form.EmailField
import com.traveloka.hotel.component.form.PasswordField
import com.traveloka.hotel.featureLogin.data.model.LoginRequest
import com.traveloka.hotel.featureLogin.presentation.viewModel.LoginViewModel
import com.traveloka.hotel.featureLogin.presentation.viewModel.LoginViewModelFactory
import com.traveloka.hotel.ui.theme.HotelmobileTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginForm(
    navController: NavController,
    viewModel: LoginViewModel = viewModel(factory = LoginViewModelFactory.getInstance(LocalContext.current))
) {
    val mContext = LocalContext.current

    val loginState = viewModel.loginState
    val emailState = viewModel.email
    val passwordState = viewModel.password

    val keyboardController = LocalSoftwareKeyboardController.current

    var isSubmitEnabled by remember {
        mutableStateOf(true)
    }
    var isLoading by remember {
        mutableStateOf(false)
    }
    val handleLogin = {
        viewModel.login(
            LoginRequest(
                email = emailState.value,
                password = passwordState.value
            )
        )
    }

    LaunchedEffect(emailState.value, passwordState.value) {
        isSubmitEnabled = emailState.value.isNotBlank() && passwordState.value.isNotBlank()
    }

    LaunchedEffect(loginState.value) {
        when (val loginStateVal = loginState.value) {
            is ResultApi.Success -> {
                isSubmitEnabled = true
                isLoading = false
                val token = loginStateVal.data
                val userPreference = UserPreference(mContext)
                if (!token.isNullOrEmpty()) {
                    userPreference.saveAuthToken(token)
                }
                navController.navigate(HotelScreens.ListHotelScreen.name)
            }
            is ResultApi.Failure -> {
                isSubmitEnabled = true
                isLoading = false
                Toast.makeText(
                    mContext,
                    loginStateVal.error,
                    Toast.LENGTH_LONG
                ).show()
            }
            is ResultApi.Loading -> {
                isSubmitEnabled = false
                isLoading = true
            }
            else -> {}
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        EmailField(
            value = emailState.value,
            onValueChange = { viewModel.setEmail(it) },
            placeholder = stringResource(R.string.email_hint),
            title = stringResource(R.string.email)
        )
        PasswordField(
            value = passwordState.value,
            onValueChange = { viewModel.setPassword(it) },
            placeholder = stringResource(R.string.password_hint),
            title = stringResource(R.string.password),
            imeAction = ImeAction.Done,
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            })
        )


        MButton(
            enabled = isSubmitEnabled,
            modifier = Modifier.widthIn(min = 200.dp),
            isLoading = isLoading,
            text = stringResource(R.string.log_in),
            onClick = handleLogin
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginFormPreview() {
    HotelmobileTheme {
        LoginScreen(rememberNavController())
    }
}