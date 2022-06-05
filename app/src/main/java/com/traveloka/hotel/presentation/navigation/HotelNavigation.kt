package com.traveloka.hotel.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.traveloka.hotel.presentation.navigation.HotelScreens
import com.traveloka.hotel.presentation.screens.detailHotel.DetailHotelScreen
import com.traveloka.hotel.presentation.screens.introduction.IntroScreen
import com.traveloka.hotel.presentation.screens.listHotel.ListHotelScreen
import com.traveloka.hotel.presentation.screens.listReview.ListReviewScreen
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
        composable(HotelScreens.ListReviewScreen.name) {
            ListReviewScreen(navController)
        }
        composable(
            HotelScreens.DetailsScreen.name + "/{hotelId}",
            arguments = listOf(navArgument("hotelId") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailHotelScreen(navController, backStackEntry.arguments?.getString("hotelId"))
        }


    }

}