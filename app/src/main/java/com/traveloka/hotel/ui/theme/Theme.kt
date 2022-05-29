package com.traveloka.hotel.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Blue,
    primaryVariant = BlueDark,
    secondary = Orange
)

private val LightColorPalette = lightColors(
    primary = Blue,
    primaryVariant = BlueDark,
    secondary = Orange
)

@Composable
fun HotelmobileTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {


    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}