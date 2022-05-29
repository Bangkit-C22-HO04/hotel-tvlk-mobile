package com.traveloka.hotel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.screens.home.HomeScreen

@Composable
fun HotelNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HotelScreens.HomeScreen.name) {

        composable(HotelScreens.HomeScreen.name) {
            //here we pass where this should lead us to
            HomeScreen()
        }


    }

}