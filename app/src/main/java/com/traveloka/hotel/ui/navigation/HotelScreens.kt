package com.traveloka.hotel.ui.navigation

enum class HotelScreens {
    HomeScreen,
    DetailsScreen,
    ListHotelScreen,
    ListReviewScreen,
    LoginScreen,
    RegisterScreen;

    companion object {
        fun fromRoute(route: String?): HotelScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            RegisterScreen.name -> RegisterScreen
            ListHotelScreen.name -> ListHotelScreen
            ListReviewScreen.name -> ListReviewScreen
            LoginScreen.name -> LoginScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}