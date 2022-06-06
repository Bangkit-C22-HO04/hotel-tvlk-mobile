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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.traveloka.hotel.component.chip.MChip
import com.traveloka.hotel.featureReview.util.getReviews
import com.traveloka.hotel.ui.theme.*
import java.text.SimpleDateFormat

@Composable
fun Reviews() {
    val reviews = getReviews()[0]
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
                modifier = Modifier.clickable { })
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
                        text = reviews.name,
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
                                    append(reviews.rating.toString())
                                }
                                append(" / 10")
                            },
                            style = MaterialTheme.typography.subtitle2,
                            color = GreyLine
                        )
                    }
                    Text(
                        text = SimpleDateFormat("dd MMMM yyyy").format(reviews.date),
                        style = MaterialTheme.typography.subtitle2,
                        color = GreyLine
                    )
                }
                MChip(
                    reviews.tag,
                    BlueChip,
                    Blue,
                    Modifier.padding(vertical = 3.dp, horizontal = 4.dp),
                    MaterialTheme.typography.caption
                )
                Text(
                    text = reviews.content,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ReviewsPreview() {
    HotelmobileTheme {
        Reviews()
    }
}