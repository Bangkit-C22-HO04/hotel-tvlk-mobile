package com.traveloka.hotel.featureReview.presentation.listReview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.traveloka.hotel.component.WrapperFunc.WithAuth
import com.traveloka.hotel.featureReview.presentation.listReview.components.ReviewList
import com.traveloka.hotel.ui.theme.BlueDark
import com.traveloka.hotel.ui.theme.HotelmobileTheme

@Composable
fun ListReviewScreen(navController: NavController) {

    WithAuth(navController = navController) {

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
                    text = "8.6",
                    style = MaterialTheme.typography.h4,
                    color = BlueDark,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Impressive",
                    style = MaterialTheme.typography.subtitle1,
                    color = BlueDark,
                    textAlign = TextAlign.Center
                )
            }
            ReviewList()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListReviewScreenPreview() {
    HotelmobileTheme {
        ListReviewScreen(rememberNavController())
    }
}