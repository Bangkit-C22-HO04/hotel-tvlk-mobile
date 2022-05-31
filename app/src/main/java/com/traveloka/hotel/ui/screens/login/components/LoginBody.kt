package com.traveloka.hotel.ui.screens.login.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.R
import com.traveloka.hotel.ui.navigation.HotelScreens
import com.traveloka.hotel.ui.screens.login.LoginScreen
import com.traveloka.hotel.ui.theme.Blue
import com.traveloka.hotel.ui.theme.Grey
import com.traveloka.hotel.ui.theme.HotelmobileTheme

@Composable
fun LoginBody(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(start = 24.dp, top = 28.dp, end = 24.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = stringResource(R.string.welcome_back),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.lets_explore_the_world),
            style = MaterialTheme.typography.subtitle1,
            color = Grey
        )
        Spacer(modifier = Modifier.height(25.dp))

        LoginForm()

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Grey)) {
                    append(stringResource(R.string.dont_have_account))
                }
                append(" ")
                withStyle(
                    style = SpanStyle(
                        color = Blue,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(stringResource(R.string.register))
                }
            },
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .clickable { navController.navigate(HotelScreens.RegisterScreen.name) }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginBodyPreview() {
    HotelmobileTheme {
        LoginScreen(rememberNavController())
    }
}