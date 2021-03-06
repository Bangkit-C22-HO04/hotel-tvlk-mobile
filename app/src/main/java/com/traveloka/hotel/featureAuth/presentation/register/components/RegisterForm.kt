package com.traveloka.hotel.featureAuth.presentation.register.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.traveloka.hotel.R
import com.traveloka.hotel.component.button.MButton
import com.traveloka.hotel.component.form.DateField
import com.traveloka.hotel.component.form.EmailField
import com.traveloka.hotel.component.form.PasswordField
import com.traveloka.hotel.component.form.RadioField
import com.traveloka.hotel.core.data.ResultApi
import com.traveloka.hotel.core.presentation.navigation.HotelScreens
import com.traveloka.hotel.core.util.showToast
import com.traveloka.hotel.featureAuth.data.model.register.RegisterRequest
import com.traveloka.hotel.featureAuth.domain.AuthViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterForm(
    viewModel: AuthViewModel,
    navController: NavController
) {
    val options = listOf(stringResource(R.string.male), stringResource(R.string.female))
    val mContext = LocalContext.current

    val registerState = viewModel.registerState
    val emailState = viewModel.email
    val passwordState = viewModel.password
    val genderState = viewModel.gender
    val birthDateState = viewModel.birthDate
    val keyboardController = LocalSoftwareKeyboardController.current

    var isSubmitEnabled by rememberSaveable {
        mutableStateOf(true)
    }
    var isLoading by rememberSaveable {
        mutableStateOf(false)
    }
    val handleRegister = {
        viewModel.register(
            RegisterRequest(
                email = emailState.value,
                password = passwordState.value,
                gender = genderState.value,
                birthDate = birthDateState.value
            )
        )
    }

    LaunchedEffect(registerState.value) {
        when (val registerStateVal = registerState.value) {
            is ResultApi.Success -> {
                isSubmitEnabled = true
                isLoading = false
                showToast(mContext, text = registerStateVal.data.toString())
                navController.navigate(HotelScreens.LoginScreen.name)
            }
            is ResultApi.Failure -> {
                isSubmitEnabled = true
                isLoading = false
                showToast(mContext, text = registerStateVal.error)
            }
            is ResultApi.Loading -> {
                isSubmitEnabled = false
                isLoading = true
            }
            else -> {}
        }

    }

    LaunchedEffect(emailState.value, passwordState.value, genderState.value, birthDateState.value) {
        isSubmitEnabled =
            emailState.value.isNotBlank() && passwordState.value.isNotBlank() && genderState.value.isNotBlank() && birthDateState.value.isNotBlank()
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
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            })
        )
        RadioField(
            title = stringResource(R.string.gender),
            options = options,
            selectedItem = genderState.value,
            onValueChange = { newGender -> viewModel.setGender(newGender) }
        )
        DateField(
            onValueChange = { viewModel.setBirthDate(it) },
            placeholder = "yyyy-mm-dd",
            title = stringResource(R.string.birth_date)
        )

        MButton(
            modifier = Modifier.widthIn(min = 200.dp),
            enabled = isSubmitEnabled,
            isLoading = isLoading,
            text = stringResource(R.string.register),
            onClick = handleRegister
        )
    }
}