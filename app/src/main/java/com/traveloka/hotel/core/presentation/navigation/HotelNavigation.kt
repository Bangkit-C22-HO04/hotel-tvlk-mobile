package com.traveloka.hotel.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.traveloka.hotel.core.presentation.screens.introduction.IntroScreen
import com.traveloka.hotel.featureAuth.presentation.login.LoginScreen
import com.traveloka.hotel.featureAuth.presentation.register.RegisterScreen
import com.traveloka.hotel.featureHotel.presentation.detailHotel.DetailHotelScreen
import com.traveloka.hotel.featureHotel.presentation.listHotel.ListHotelScreen
import com.traveloka.hotel.featureReview.presentation.listReview.ListReviewScreen

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
            arguments = listOf(navArgument("hotelId") { type = NavType.LongType })
        ) { backStackEntry ->
            DetailHotelScreen(navController, backStackEntry.arguments?.getLong("hotelId"))
        }


    }

}