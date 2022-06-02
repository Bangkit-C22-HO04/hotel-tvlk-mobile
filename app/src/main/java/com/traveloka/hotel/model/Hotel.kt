package com.traveloka.hotel.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hotel(
    val id: String,
    val imgUrl: String,
    val name: String,
    val city: String,
    val price: Long,
    val type: String,
    val rating: Double,
    val reviews: Long
): Parcelable
