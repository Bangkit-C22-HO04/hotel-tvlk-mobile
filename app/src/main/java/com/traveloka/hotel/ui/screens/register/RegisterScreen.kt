package com.traveloka.hotel.ui.screens.register

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
import com.traveloka.hotel.ui.screens.register.components.RegisterBody
import com.traveloka.hotel.ui.screens.register.components.RegisterHeader
import com.traveloka.hotel.ui.theme.BlueBg
import com.traveloka.hotel.ui.theme.HotelmobileTheme


@Composable
fun RegisterScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(BlueBg)
            .fillMaxSize()
    ) {
        Column {

            RegisterHeader(navController)
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .background(Color.White)
            ) {

                RegisterBody(navController)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun Preview() {
    HotelmobileTheme {
        RegisterScreen(rememberNavController())
    }
}