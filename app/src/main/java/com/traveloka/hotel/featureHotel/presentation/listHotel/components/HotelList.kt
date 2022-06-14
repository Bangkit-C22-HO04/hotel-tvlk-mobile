package com.traveloka.hotel.featureHotel.presentation.listHotel.components

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.traveloka.hotel.core.data.ResultApi
import com.traveloka.hotel.core.util.showToast
import com.traveloka.hotel.featureHotel.data.model.Hotel
import com.traveloka.hotel.featureHotel.data.model.HotelListRequest
import com.traveloka.hotel.featureHotel.domain.HotelViewModel
import kotlinx.coroutines.launch

@Composable
fun HotelList(
    navController: NavController,
    viewModel: HotelViewModel
) {
    val context = LocalContext.current
    val hotelListState = viewModel.hotelListState
    val city = viewModel.city
    val travelPurpose = viewModel.travelPurpose
    val scope = rememberCoroutineScope()

    val hotelList = remember {
        mutableStateListOf<Hotel>()
    }
    val isLoading = rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {
        scope.launch {
            viewModel.getHotelList(
                HotelListRequest(
                    location = city.value,
                    travelPurpose = travelPurpose.value
                )
            )
        }
    }

    LaunchedEffect(hotelListState.value) {
        when (val state = hotelListState.value) {
            is ResultApi.Loading -> {
                isLoading.value = true
                hotelList.clear()
            }
            is ResultApi.Success -> {
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
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
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