package com.traveloka.hotel.navigation

enum class HotelScreens {
    HomeScreen,
    DetailsScreen,
    RegisterScreen;

    companion object {
        fun fromRoute(route: String?): HotelScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            RegisterScreen.name -> RegisterScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}