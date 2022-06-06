package com.traveloka.hotel.featureAuth.data.model.register

import com.google.gson.annotations.SerializedName

data class RegisterRequest(

    @field:SerializedName("password")
    val password: String,

    @field:SerializedName("gender")
    val gender: String,

    @field:SerializedName("birth_date")
    val birthDate: String,

    @field:SerializedName("email")
    val email: String
)
