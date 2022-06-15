package com.traveloka.hotel.featureHotel.presentation.detailHotel.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.traveloka.hotel.component.chip.MChip
import com.traveloka.hotel.core.presentation.navigation.HotelScreens
import com.traveloka.hotel.featureHotel.data.model.Data
import com.traveloka.hotel.ui.theme.*

@Composable
fun Reviews(navController: NavController, hotel: MutableState<Data>) {
    if (hotel.value.ratings != null && hotel.value.ratings?.size!! > 0) {
        val reviews = hotel.value.ratings?.get(0)

        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Reviews", style = MaterialTheme.typography.body1)
                Text(
                    text = "More",
                    style = MaterialTheme.typography.body2,
                    color = GreyLine,
                    modifier = Modifier.clickable {
                        navController.currentBackStackEntry?.arguments?.putLong("hotelId", hotel.value.id!!)
                        navController.navigate(HotelScreens.ListReviewScreen.name + "/${hotel.value.id}", )
                    })
            }
            Card(shape = RoundedCornerShape(8.dp), elevation = 0.dp) {
                Column(
                    modifier = Modifier
                        .background(GreyReview)
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = ""
                        )
                        Text(
                            text = reviews?.name.toString(),
                            style = MaterialTheme.typography.body2
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "",
                                tint = YellowStar
                            )
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = YellowStar
                                        )
                                    ) {
                                        append(reviews?.rating.toString())
                                    }
                                    append(" / 10")
                                },
                                style = MaterialTheme.typography.subtitle2,
                                color = GreyLine
                            )
                        }
                    }
                    MChip(
                        reviews?.travelPurposes.toString(),
                        BlueChip,
                        Blue,
                        Modifier.padding(vertical = 3.dp, horizontal = 4.dp),
                        MaterialTheme.typography.caption
                    )
                    Text(
                        text = reviews?.content.toString(),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}