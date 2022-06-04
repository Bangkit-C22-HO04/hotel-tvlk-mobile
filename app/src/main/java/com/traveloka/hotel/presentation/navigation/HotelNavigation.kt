package com.traveloka.hotel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.presentation.screens.introduction.IntroScreen
import com.traveloka.hotel.presentation.screens.listHotel.ListHotelScreen
import com.traveloka.hotel.presentation.screens.login.LoginScreen
import com.traveloka.hotel.presentation.screens.register.RegisterScreen

@Composable
fun HotelNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HotelScreens.IntroScreen.name) {

        composable(HotelScreens.IntroScreen.name) {
            IntroScreen(navController)
        }
        composable(HotelScreens.RegisterScreen.name) {
            RegisterScreen(navController)
        }
        composable(HotelScreens.LoginScreen.name) {
            LoginScreen(navController)
        }
        composable(HotelScreens.ListHotelScreen.name) {
            ListHotelScreen(navController)
        }


    }

}