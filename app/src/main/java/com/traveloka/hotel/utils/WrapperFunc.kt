package com.traveloka.hotel.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.traveloka.hotel.data.local.UserPreference
import com.traveloka.hotel.presentation.navigation.HotelScreens

object WrapperFunc {

    @Composable
    fun WithAuth(navController: NavController, content: @Composable () -> Unit) {
        val context = LocalContext.current
        val userPreference = UserPreference.UserPreference(context)

        LaunchedEffect(userPreference.fetchAuthToken()) {
            if (userPreference.fetchAuthToken().isNullOrEmpty()) {
                navController.navigate(HotelScreens.LoginScreen.name)
            }
        }

        if (!userPreference.fetchAuthToken().isNullOrEmpty()) {
            content()
        }

    }

    @Composable
    fun WithNonAuth(navController: NavController, content: @Composable () -> Unit) {
        val context = LocalContext.current
        val userPreference = UserPreference.UserPreference(context)

        LaunchedEffect(userPreference.fetchAuthToken()) {
            if (!userPreference.fetchAuthToken().isNullOrEmpty()) {
                navController.navigate(HotelScreens.ListHotelScreen.name)
            }
        }

        if (userPreference.fetchAuthToken().isNullOrEmpty()) {
            content()
        }

    }
}