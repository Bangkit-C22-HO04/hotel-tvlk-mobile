package com.traveloka.hotel.featureReview.presentation.listReview

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.component.WrapperFunc.WithAuth
import com.traveloka.hotel.core.data.ResultApi
import com.traveloka.hotel.core.util.showToast
import com.traveloka.hotel.featureHotel.data.model.Data
import com.traveloka.hotel.featureHotel.data.model.HotelDetailRequest
import com.traveloka.hotel.featureHotel.domain.HotelDetailViewModel
import com.traveloka.hotel.featureReview.presentation.listReview.components.ReviewList
import com.traveloka.hotel.ui.theme.BlueDark
import com.traveloka.hotel.ui.theme.HotelmobileTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ListReviewScreen(navController: NavController, hotelId: Long?) {
    WithAuth(navController = navController) {

        val viewModel: HotelDetailViewModel = hiltViewModel()

        val scope = rememberCoroutineScope()
        val context = LocalContext.current
        val hotelDetailState = viewModel.hotelDetailState

        val hotel = remember {
            mutableStateOf(Data())
        }
        val isLoading = rememberSaveable {
            mutableStateOf(false)
        }

        LaunchedEffect(true) {
            scope.launch(Dispatchers.IO) {
                viewModel.getHotelDetail(HotelDetailRequest(hotelId ?: 3000010039024))
            }
        }

        LaunchedEffect(hotelDetailState.value) {
            when (val state = hotelDetailState.value) {
                is ResultApi.Loading -> {
                    isLoading.value = true
                }
                is ResultApi.Success -> {
                    isLoading.value = false
                    val resultDetail = state.data
                    if (resultDetail != null) {
                        hotel.value = resultDetail.data
                    }
                }
                is ResultApi.Failure -> {
                    isLoading.value = false
                    showToast(context, state.error)
                }
                else -> {}
            }
        }

        val data = hotel.value

        if (isLoading.value || data.name.isNullOrBlank()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            val rating = data.totalRating ?: 0.0
            val ratingTitle: String = if (rating.compareTo(9) > 0) {
                "Superb"
            } else if (rating.compareTo(8) > 0) {
                "Impressive"
            } else if (rating.compareTo(7) > 0) {
                "Convenient"
            } else if (rating.compareTo(6) > 0) {
                "Good"
            } else if (rating.compareTo(5) > 0) {
                "Acceptable"
            } else if (rating.compareTo(4) > 0) {
                "Mixed"
            } else {
                "Poor"
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 32.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = data.totalRating.toString(),
                        style = MaterialTheme.typography.h4,
                        color = BlueDark,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = ratingTitle,
                        style = MaterialTheme.typography.subtitle1,
                        color = BlueDark,
                        textAlign = TextAlign.Center
                    )
                }
                ReviewList(data)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListReviewScreenPreview() {
    HotelmobileTheme {
        ListReviewScreen(rememberNavController(), 3000010039024)
    }
}