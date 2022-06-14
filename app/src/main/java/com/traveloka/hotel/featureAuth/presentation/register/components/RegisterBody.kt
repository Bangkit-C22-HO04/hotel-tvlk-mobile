package com.traveloka.hotel.featureAuth.presentation.register.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.traveloka.hotel.R
import com.traveloka.hotel.core.presentation.navigation.HotelScreens
import com.traveloka.hotel.featureAuth.domain.AuthViewModel
import com.traveloka.hotel.ui.theme.Blue
import com.traveloka.hotel.ui.theme.Grey

@Composable
fun RegisterBody(
    navController: NavController, viewModel: AuthViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier
            .padding(start = 24.dp, top = 28.dp, end = 24.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = stringResource(R.string.welcome),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.create_an_account),
            style = MaterialTheme.typography.subtitle1,
            color = Grey
        )
        Spacer(modifier = Modifier.height(25.dp))

        RegisterForm(navController = navController, viewModel = viewModel)

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Grey)) {
                    append(stringResource(R.string.already_have_account))
                }
                append(" ")
                withStyle(
                    style = SpanStyle(
                        color = Blue,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(stringResource(R.string.log_in))
                }
            },
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .clickable {
                    viewModel.clearForm()
                    navController.navigate(HotelScreens.LoginScreen.name)
                }
        )
    }
}