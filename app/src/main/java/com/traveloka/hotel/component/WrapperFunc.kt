package com.traveloka.hotel.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.traveloka.hotel.core.domain.MainViewModel
import com.traveloka.hotel.core.presentation.navigation.HotelScreens

object WrapperFunc {

    @Composable
    fun WithAuth(
        navController: NavController,
        viewModel: MainViewModel = hiltViewModel(),
        content: @Composable () -> Unit
    ) {
        val token = viewModel.getToken()

        LaunchedEffect(token) {
            if (token.isNullOrEmpty()) {
                navController.navigate(HotelScreens.LoginScreen.name)
            }
        }

        if (!token.isNullOrEmpty()) {
            content()
        }

    }

    @Composable
    fun WithNonAuth(
        navController: NavController,
        viewModel: MainViewModel = hiltViewModel(),
        content: @Composable () -> Unit
    ) {
        val token = viewModel.getToken()

        LaunchedEffect(token) {
            if (!token.isNullOrEmpty()) {
                navController.navigate(HotelScreens.ListHotelScreen.name)
            }
        }

        if (token.isNullOrEmpty()) {
            content()
        }

    }
}