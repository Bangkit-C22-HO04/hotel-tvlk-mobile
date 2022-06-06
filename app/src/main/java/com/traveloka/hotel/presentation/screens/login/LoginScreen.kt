package com.traveloka.hotel.presentation.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.presentation.screens.login.components.LoginBody
import com.traveloka.hotel.presentation.screens.login.components.LoginHeader
import com.traveloka.hotel.ui.theme.BlueBg
import com.traveloka.hotel.ui.theme.HotelmobileTheme
import com.traveloka.hotel.utils.WrapperFunc.WithNonAuth

@Composable
fun LoginScreen(navController: NavController) {
    WithNonAuth(navController = navController) {

        Box(
            modifier = Modifier
                .background(BlueBg)
                .fillMaxSize()
        ) {
            Column {

                LoginHeader(navController)
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                        .background(Color.White)
                ) {

                    LoginBody(navController)
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    HotelmobileTheme {
        LoginScreen(rememberNavController())
    }
}