package com.traveloka.hotel.navigation

import java.lang.IllegalArgumentException

enum class HotelScreens {
    HomeScreen,
    DetailsScreen;
    companion object {
        fun fromRoute(route: String?): HotelScreens
                = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}