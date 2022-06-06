package com.traveloka.hotel.featureAuth.presentation.register.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.traveloka.hotel.R
import com.traveloka.hotel.core.presentation.navigation.HotelScreens

@Composable
fun RegisterHeader(navController: NavController) {
    Row(
        modifier = Modifier
            .padding(start = 14.dp, top = 8.dp, end = 24.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.navigate(HotelScreens.IntroScreen.name) }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                tint = Color.White,
                modifier = Modifier.size(30.dp),
                contentDescription = stringResource(R.string.back_to_intro)
            )
        }
        Text(
            text = stringResource(R.string.register),
            style = MaterialTheme.typography.h5,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}