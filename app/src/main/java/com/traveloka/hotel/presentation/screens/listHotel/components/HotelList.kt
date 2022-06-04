package com.traveloka.hotel.presentation.screens.listHotel.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.presentation.screens.listHotel.ListHotelScreen
import com.traveloka.hotel.ui.screens.listHotel.components.HotelItem
import com.traveloka.hotel.ui.theme.HotelmobileTheme
import com.traveloka.hotel.utils.getHotels

@Composable
fun HotelList(navController: NavController) {
    val hotels = getHotels()
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
            items(hotels, key = { it.id }) { hotel ->
                HotelItem(hotel = hotel, navController = navController)
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