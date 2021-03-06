package com.traveloka.hotel.featureReview.data.model

import java.util.*

data class Review(
    val id: String,
    val name: String,
    val rating: Double,
    val date: Date,
    val tag: String,
    val content: String,
)