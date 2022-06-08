package com.traveloka.hotel.featureHotel.presentation.detailHotel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.traveloka.hotel.R
import com.traveloka.hotel.component.WrapperFunc.WithAuth
import com.traveloka.hotel.core.data.ResultApi
import com.traveloka.hotel.core.presentation.navigation.HotelScreens
import com.traveloka.hotel.core.util.showToast
import com.traveloka.hotel.featureHotel.data.model.Data
import com.traveloka.hotel.featureHotel.data.model.HotelDetailRequest
import com.traveloka.hotel.featureHotel.domain.HotelDetailViewModel
import com.traveloka.hotel.featureHotel.domain.HotelDetailViewModelFactory
import com.traveloka.hotel.featureHotel.presentation.detailHotel.components.Content
import com.traveloka.hotel.featureHotel.presentation.detailHotel.components.Reviews
import com.traveloka.hotel.ui.theme.GreyLight
import com.traveloka.hotel.ui.theme.HotelmobileTheme

@Composable
fun DetailHotelScreen(navController: NavController, hotelId: Long?) {
    WithAuth(navController = navController) {
        if (hotelId != null) {
            HotelDetail(navController, hotelId)
        }
    }
}

@Composable
fun HotelDetail(
    navController: NavController,
    hotelId: Long,
    viewModel: HotelDetailViewModel = viewModel(
        factory = HotelDetailViewModelFactory.getInstance(
            LocalContext.current
        )
    )
) {
    val context = LocalContext.current
    val hotelDetailState = viewModel.hotelDetailState

    val hotel = remember {
        mutableStateOf(Data())
    }
    val isLoading = rememberSaveable {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {
        viewModel.getHotelDetail(HotelDetailRequest(hotelId))
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
                    hotel.value= resultDetail.data
                }
            }
            is ResultApi.Failure -> {
                isLoading.value = false
                showToast(context, state.error)
            }
            else -> {}
        }
    }

    if (isLoading.value) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        Box(Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(hotel.value.imageUrl)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(id = R.drawable.logo_full_color),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                    Content(hotel.value)
                    Divider(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = GreyLight,
                        thickness = 1.dp
                    )
                    Reviews(navController, hotel.value.ratings)
                }
            }

            IconButton(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                onClick = { navController.navigate(HotelScreens.ListHotelScreen.name) }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp),
                    contentDescription = stringResource(R.string.back_to_intro)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListHotelScreenPreview() {
    HotelmobileTheme {
        DetailHotelScreen(rememberNavController(), 3000010039024)
    }
}