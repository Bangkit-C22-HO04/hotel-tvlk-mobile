package com.traveloka.hotel.featureAuth.data.model.register

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: Boolean
)
