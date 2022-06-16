package com.traveloka.hotel.featureHotel.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HotelListRequest(

    @field:SerializedName("location")
    val location: String,

    @field:SerializedName("travel_purposes")
    val travelPurpose: String
) : Parcelable
