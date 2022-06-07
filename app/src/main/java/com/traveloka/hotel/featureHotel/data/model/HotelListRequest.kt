package com.traveloka.hotel.featureHotel.data.model

import com.google.gson.annotations.SerializedName

data class HotelListRequest(

    @field:SerializedName("location")
    val location: String,

    @field:SerializedName("travel_purposes")
    val travelPurpose: String
)
