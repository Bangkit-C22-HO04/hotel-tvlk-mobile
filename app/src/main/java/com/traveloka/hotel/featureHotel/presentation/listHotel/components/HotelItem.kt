package com.traveloka.hotel.featureHotel.presentation.listHotel.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.traveloka.hotel.R
import com.traveloka.hotel.core.presentation.navigation.HotelScreens
import com.traveloka.hotel.featureHotel.data.model.Hotel
import com.traveloka.hotel.ui.theme.Grey
import com.traveloka.hotel.ui.theme.GreyLine
import com.traveloka.hotel.ui.theme.Orange
import com.traveloka.hotel.ui.theme.YellowStar

@Composable
fun HotelItem(hotel: Hotel, navController: NavController) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            navController.navigate(HotelScreens.DetailsScreen.name + "/${hotel.id}")
        }
    ) {
        Row {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(hotel.imgUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = R.drawable.logo_full_color),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(170.dp)
            )
            Column(
                modifier = Modifier
                    .height(170.dp)
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = hotel.name,
                        style = MaterialTheme.typography.h6,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "",
                            tint = YellowStar
                        )
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Grey,
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append(hotel.rating.toString())
                                }
                                append(" (${hotel.reviews} reviews)")
                            },
                            style = MaterialTheme.typography.subtitle1,
                            color = GreyLine
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "",
                            tint = GreyLine
                        )
                        Text(
                            text = hotel.city,
                            style = MaterialTheme.typography.subtitle1,
                            color = Grey,
                        )

                    }
                }
                Text(
                    text = buildAnnotatedString {
                        append("Rp ${hotel.price}")
                        withStyle(
                            style = SpanStyle(
                                color = GreyLine,
                                fontSize = 14.sp
                            )
                        ) {
                            append("/night")
                        }
                    },
                    style = MaterialTheme.typography.body1,
                    color = Orange,
                    fontWeight = FontWeight.Bold
                )


            }
        }
    }
}