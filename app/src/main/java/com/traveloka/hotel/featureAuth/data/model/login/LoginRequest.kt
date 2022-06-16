package com.traveloka.hotel.featureAuth.data.model.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest(

    @field:SerializedName("password")
    val password: String,

    @field:SerializedName("email")
    val email: String
) : Parcelable
