package com.traveloka.hotel.featureHotel.data.model

import com.google.gson.annotations.SerializedName

data class HotelListResponse(

    @field:SerializedName("data")
    val data: List<Hotel>
)

