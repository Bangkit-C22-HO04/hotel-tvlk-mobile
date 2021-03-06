package com.traveloka.hotel.component.form

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun FormTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.body1,
    )
}