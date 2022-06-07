package com.traveloka.hotel.featureHotel.presentation.detailHotel.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.traveloka.hotel.component.chip.MChip
import com.traveloka.hotel.featureHotel.data.model.HotelItem
import com.traveloka.hotel.featureHotel.util.getHotels
import com.traveloka.hotel.ui.theme.*

@Composable
fun Content(hotel: HotelItem) {
    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = hotel.name, style = MaterialTheme.typography.h6)
        MChip(
            hotel.type,
            OrangeChip,
            Orange,
            Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
            MaterialTheme.typography.body2
        )
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "",
                    tint = GreyLine
                )
                Text(
                    text = hotel.location,
                    style = MaterialTheme.typography.body2,
                    color = Grey,
                )
            }
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
                        append(" (${hotel.totalReview} reviews)")
                    },
                    style = MaterialTheme.typography.body2,
                    color = GreyLine
                )
            }
        }
        Column {
            Text(text = "Start at", style = MaterialTheme.typography.subtitle2, color = GreyLine)
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
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ContentPreview() {
    HotelmobileTheme {
        Content(getHotels()[0])
    }
}