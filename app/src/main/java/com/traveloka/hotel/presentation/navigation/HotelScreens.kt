package com.traveloka.hotel.presentation.navigation

enum class HotelScreens {
    DetailsScreen,
    ListHotelScreen,
    ListReviewScreen,
    LoginScreen,
    IntroScreen,
    RegisterScreen;

    companion object {
        fun fromRoute(route: String?): HotelScreens = when (route?.substringBefore("/")) {
            IntroScreen.name -> IntroScreen
            DetailsScreen.name -> DetailsScreen
            RegisterScreen.name -> RegisterScreen
            ListHotelScreen.name -> ListHotelScreen
            ListReviewScreen.name -> ListReviewScreen
            LoginScreen.name -> LoginScreen
            null -> IntroScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}