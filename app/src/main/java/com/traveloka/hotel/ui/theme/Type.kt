package com.traveloka.hotel.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.traveloka.hotel.R

val MuseoSans = FontFamily(
    Font(R.font.museo_sans_500),
    Font(R.font.museo_sans_700, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    h4 = TextStyle(
        fontFamily = MuseoSans,
        fontWeight = FontWeight.W700,
        fontSize = 34.sp
    ),
    h5 = TextStyle(
        fontFamily = MuseoSans,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = MuseoSans,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        fontFamily = MuseoSans,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = MuseoSans,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = MuseoSans,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = MuseoSans,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    ),
)