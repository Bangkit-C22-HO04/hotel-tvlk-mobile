package com.traveloka.hotel.featureLogin.domain

import com.traveloka.hotel.featureLogin.data.model.LoginResponse
import okhttp3.RequestBody
import retrofit2.Call

interface ILoginRepository {

    fun login(request: RequestBody): Call<LoginResponse>
}