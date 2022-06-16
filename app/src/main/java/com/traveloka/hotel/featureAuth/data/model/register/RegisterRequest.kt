package com.traveloka.hotel.featureAuth.data.model.register

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisterRequest(

    @field:SerializedName("password")
    val password: String,

    @field:SerializedName("gender")
    val gender: String,

    @field:SerializedName("birth_date")
    val birthDate: String,

    @field:SerializedName("email")
    val email: String
) : Parcelable
