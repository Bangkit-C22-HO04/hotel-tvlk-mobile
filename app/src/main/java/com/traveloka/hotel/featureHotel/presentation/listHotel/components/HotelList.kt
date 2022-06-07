package com.traveloka.hotel.featureHotel.presentation.listHotel.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.core.data.ResultApi
import com.traveloka.hotel.core.util.showToast
import com.traveloka.hotel.featureHotel.data.model.HotelItem
import com.traveloka.hotel.featureHotel.data.model.HotelListRequest
import com.traveloka.hotel.featureHotel.domain.HotelViewModel
import com.traveloka.hotel.featureHotel.presentation.listHotel.ListHotelScreen
import com.traveloka.hotel.ui.theme.HotelmobileTheme

@Composable
fun HotelList(
    navController: NavController,
    viewModel: HotelViewModel
) {
    val context = LocalContext.current
    val hotelListState = viewModel.hotelListState
    val location = viewModel.location
    val travelPurpose = viewModel.travelPurpose


    val hotelList = remember {
        mutableStateListOf<HotelItem>()
    }
    val isLoading = rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {
        viewModel.getHotelList(
            HotelListRequest(
                location = location.value,
                travelPurpose = travelPurpose.value
            )
        )
    }

    LaunchedEffect(hotelListState.value) {
        when (val state = hotelListState.value) {
            is ResultApi.Loading -> {
                isLoading.value = true
            }
            is ResultApi.Success -> {
                hotelList.clear()
                isLoading.value = false
                val resultHotels = state.data?.data ?: emptyList()
                hotelList.addAll(resultHotels)
            }
            is ResultApi.Failure -> {
                isLoading.value = false
                showToast(context, state.error)
                hotelList.addAll(emptyList())
            }
            else -> {}
        }
    }

    if (isLoading.value) {
        CircularProgressIndicator()
    } else {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Text(
                    text = "Recommended Hotels",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
                Icon(imageVector = Icons.Default.Apartment, contentDescription = "")
            }

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(hotelList, key = { it.id }) { hotel ->
                    HotelItem(hotel = hotel, navController = navController)
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ListHotelScreenPreview() {
    HotelmobileTheme {
        ListHotelScreen(rememberNavController())
    }
}