package com.traveloka.hotel.common.network

import com.traveloka.hotel.featureAuth.data.model.login.LoginResponse
import com.traveloka.hotel.featureAuth.data.model.register.RegisterResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(ApiConstants.LOGIN)
    fun postLogin(@Body request: RequestBody): Call<LoginResponse>

    @POST(ApiConstants.REGISTER)
    fun postRegister(@Body request: RequestBody): Call<RegisterResponse>
}