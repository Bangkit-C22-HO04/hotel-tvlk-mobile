package com.traveloka.hotel.featureRegister.domain

import com.traveloka.hotel.featureRegister.data.model.RegisterResponse
import okhttp3.RequestBody
import retrofit2.Call

interface IRegisterRepository {
    fun register(request: RequestBody): Call<RegisterResponse>
}