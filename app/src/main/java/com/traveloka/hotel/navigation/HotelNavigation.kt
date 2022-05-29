package com.traveloka.hotel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.screens.home.HomeScreen
import com.traveloka.hotel.screens.register.RegisterScreen

@Composable
fun HotelNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HotelScreens.HomeScreen.name) {

        composable(HotelScreens.HomeScreen.name) {
            HomeScreen()
        }
        composable(HotelScreens.RegisterScreen.name) {
            RegisterScreen(navController)
        }


    }

}