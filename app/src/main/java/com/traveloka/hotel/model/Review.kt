package com.traveloka.hotel.model

import java.util.*

data class Review(
    val id: String,
    val name: String,
    val rating: Double,
    val date: String,
    val tag: String,
    val content: String,
)
