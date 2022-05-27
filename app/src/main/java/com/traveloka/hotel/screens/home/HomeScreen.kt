package com.traveloka.hotel.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            ) {
                Text(text = "Hotel")

            }
        },
    ) {
        MainContent()
    }

}

@Composable
fun MainContent() {
    Column(modifier = Modifier.padding(12.dp)) {
        Text(text = "Hello HH!", style = MaterialTheme.typography.h4)

    }

}