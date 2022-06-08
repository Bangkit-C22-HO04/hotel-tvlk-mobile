package com.traveloka.hotel.featureHotel.data.model

import com.google.gson.annotations.SerializedName

data class HotelDetailResponse(

    @field:SerializedName("data")
    val data: Data
)

data class Data(

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("image_url")
    val imageUrl: String? = null,

    @field:SerializedName("ratings")
    val ratings: List<RatingsItem>? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("total_review")
    val totalReview: Int? = 0,

    @field:SerializedName("location")
    val location: String? = null,

    @field:SerializedName("total_rating")
    val totalRating: Double? = 0.0,

    @field:SerializedName("id")
    val id: Long? = 0,

    @field:SerializedName("type")
    val type: String? = null
)

data class RatingsItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("rating")
    val rating: Int,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("travel_purposes")
    val travelPurposes: String,

    @field:SerializedName("content")
    val content: String
)
