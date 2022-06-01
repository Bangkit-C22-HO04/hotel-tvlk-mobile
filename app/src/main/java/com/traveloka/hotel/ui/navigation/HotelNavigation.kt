package com.traveloka.hotel.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.ui.screens.home.HomeScreen
import com.traveloka.hotel.ui.screens.listHotel.ListHotelScreen
import com.traveloka.hotel.ui.screens.register.RegisterScreen

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
        composable(HotelScreens.ListHotelScreen.name) {
            ListHotelScreen(navController)
        }


    }

}