package com.traveloka.hotel.featureReview.presentation.listReview.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.featureHotel.data.model.Data
import com.traveloka.hotel.featureReview.presentation.listReview.ListReviewScreen
import com.traveloka.hotel.ui.theme.HotelmobileTheme

@Composable
fun ReviewList(reviewListData: Data) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(reviewListData.ratings!!, key = { it.id }) { review ->
            ReviewItem(review = review)
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