package com.traveloka.hotel.featureHotel.data.model

import com.google.gson.annotations.SerializedName

data class Hotel(
    @field:SerializedName("price")
    val price: String,

    @field:SerializedName("image_url")
    val imageUrl: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("total_review")
    val totalReview: Int,

    @field:SerializedName("location")
    val location: String,

    @field:SerializedName("id")
    val id: Long,

    @field:SerializedName("type")
    val type: String
)
