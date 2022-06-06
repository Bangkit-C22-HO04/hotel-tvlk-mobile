package com.traveloka.hotel.featureAuth.data.model.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("token")
    val token: String? = null
)
