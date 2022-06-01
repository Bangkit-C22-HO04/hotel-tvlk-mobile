package com.traveloka.hotel.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.traveloka.hotel.ui.navigation.HotelScreens
import com.traveloka.hotel.ui.widgets.button.MButton

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            ) {
                Text(text = "Hotel")

            }
        },
    ) {
        MainContent(navController)
    }

}

@Composable
fun MainContent(navController: NavController) {
    Column(modifier = Modifier.padding(12.dp)) {
        Text(text = "Hello HH!", style = MaterialTheme.typography.h4)
        MButton(
            text = "Lets Start",
            onClick = { navController.navigate(HotelScreens.LoginScreen.name) })
    }

}