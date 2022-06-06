package com.traveloka.hotel.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.traveloka.hotel.common.domain.MainViewModel
import com.traveloka.hotel.common.domain.MainViewModelFactory
import com.traveloka.hotel.common.presentation.navigation.HotelScreens

object WrapperFunc {

    @Composable
    fun WithAuth(
        navController: NavController,
        viewModel: MainViewModel = viewModel(factory = MainViewModelFactory.getInstance(LocalContext.current)),
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
        viewModel: MainViewModel = viewModel(factory = MainViewModelFactory.getInstance(LocalContext.current)),
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