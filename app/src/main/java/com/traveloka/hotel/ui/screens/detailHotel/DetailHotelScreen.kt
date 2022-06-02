package com.traveloka.hotel.ui.screens.detailHotel

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.traveloka.hotel.R
import com.traveloka.hotel.model.Hotel
import com.traveloka.hotel.ui.screens.detailHotel.components.Content
import com.traveloka.hotel.ui.theme.GreyLight
import com.traveloka.hotel.ui.theme.HotelmobileTheme
import com.traveloka.hotel.utils.getHotels

@Composable
fun DetailHotelScreen(hotel: Hotel) {
    Column {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(hotel.imgUrl)
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
            Content(hotel)
            Divider(
                modifier = Modifier.padding(horizontal = 8.dp),
                color = GreyLight,
                thickness = 1.dp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListHotelScreenPreview() {
    HotelmobileTheme {
        DetailHotelScreen(getHotels()[0])
    }
}