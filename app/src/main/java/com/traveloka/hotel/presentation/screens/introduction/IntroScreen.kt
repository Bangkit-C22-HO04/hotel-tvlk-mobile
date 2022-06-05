package com.traveloka.hotel.presentation.screens.introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.R
import com.traveloka.hotel.presentation.navigation.HotelScreens
import com.traveloka.hotel.ui.theme.Blue
import com.traveloka.hotel.ui.theme.BlueDark
import com.traveloka.hotel.ui.theme.HotelmobileTheme
import com.traveloka.hotel.ui.widgets.button.MButton
import com.traveloka.hotel.utils.WrapperFunc.WithNonAuth

@Composable
fun IntroScreen(
    navController: NavController
) {
    WithNonAuth(navController = navController) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(brush = Brush.radialGradient(colors = listOf(BlueDark, Blue))),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 56.dp)
                    .height(45.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp),
                    painter = painterResource(id = R.drawable.logo_white),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 18.dp)
                    .height(87.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.image_intro),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
            }
            Text(
                modifier = Modifier.padding(bottom = 50.dp),
                text = "Let’s search cheap hotels in 3 easy steps here!",
                style = MaterialTheme.typography.body1, color = Color.White
            )
            Text(
                modifier = Modifier.padding(bottom = 12.dp),
                text = "#MulaiAjaDuluTravelokaKemudian”",
                style = MaterialTheme.typography.body2,
                color = Color.White
            )
            MButton(
                text = "Let’s Start!",
                bgColor = Color.White,
                textColor = Blue,
                onClick = { navController.navigate(HotelScreens.LoginScreen.name) })
        }
    }
}

@Preview(name = "IntroScreen", showSystemUi = true)
@Composable
private fun PreviewIntroScreen() {
    HotelmobileTheme {

        IntroScreen(rememberNavController())
    }
}