package com.traveloka.hotel.featureReview.presentation.listReview.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.traveloka.hotel.component.chip.MChip
import com.traveloka.hotel.featureHotel.data.model.RatingsItem
import com.traveloka.hotel.ui.theme.Blue
import com.traveloka.hotel.ui.theme.BlueChip
import com.traveloka.hotel.ui.theme.GreyLine
import com.traveloka.hotel.ui.theme.YellowStar

@Composable
fun ReviewItem(review: RatingsItem) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { }
    ) {
        Column(
            modifier = Modifier
                .height(160.dp)
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "",
                )
                Text(
                    text = review.name,
                    style = MaterialTheme.typography.subtitle2
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "",
                        tint = YellowStar,
                        modifier = Modifier
                            .height(20.dp),
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    letterSpacing = 0.4.sp,
                                    color = YellowStar
                                )
                            ) {
                                append(review.rating.toString())
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp,
                                    letterSpacing = 0.4.sp,
                                    color = GreyLine
                                )
                            ) {
                                append(" / 10")
                            }
                        }
                    )
                }
            }
            MChip(
                review.travelPurposes,
                BlueChip,
                Blue,
                Modifier.padding(vertical = 3.dp, horizontal = 4.dp),
                MaterialTheme.typography.caption
            )
            Text(
                text = review.content,
                style = MaterialTheme.typography.subtitle2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}