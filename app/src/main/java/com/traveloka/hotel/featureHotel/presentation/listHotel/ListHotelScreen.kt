package com.traveloka.hotel.featureHotel.presentation.listHotel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.traveloka.hotel.R
import com.traveloka.hotel.component.WrapperFunc.WithAuth
import com.traveloka.hotel.featureHotel.domain.HotelViewModel
import com.traveloka.hotel.featureHotel.presentation.listHotel.components.FilterBox
import com.traveloka.hotel.featureHotel.presentation.listHotel.components.HotelList
import com.traveloka.hotel.ui.theme.Blue

@Composable
fun ListHotelScreen(navController: NavController) {
    WithAuth(navController = navController) {
        HotelContainer(navController)
    }
}

@Composable
fun HotelContainer(
    navController: NavController,
    viewModel: HotelViewModel = hiltViewModel()
) {
    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(106.dp)
                .background(Blue)
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_white),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "logo"
                )
            }
            FilterBox(viewModel)
            HotelList(navController, viewModel)
        }
    }
}