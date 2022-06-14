package com.traveloka.hotel.featureAuth.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.traveloka.hotel.component.WrapperFunc.WithNonAuth
import com.traveloka.hotel.featureAuth.presentation.login.components.LoginBody
import com.traveloka.hotel.featureAuth.presentation.login.components.LoginHeader
import com.traveloka.hotel.ui.theme.BlueBg

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
