package com.traveloka.hotel.core.network

import com.traveloka.hotel.featureAuth.data.model.login.LoginResponse
import com.traveloka.hotel.featureAuth.data.model.register.RegisterResponse
import com.traveloka.hotel.featureHotel.data.model.HotelDetailResponse
import com.traveloka.hotel.featureHotel.data.model.HotelListResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(ApiConstants.LOGIN)
    fun postLogin(@Body request: RequestBody): Call<LoginResponse>

    @POST(ApiConstants.REGISTER)
    fun postRegister(@Body request: RequestBody): Call<RegisterResponse>

    @POST(ApiConstants.HOTEL_RANKING)
    fun getHotelRanking(@Body request: RequestBody): Call<HotelListResponse>

    @POST(ApiConstants.HOTEL_DETAIL)
    fun getHotelDetail(@Body request: RequestBody): Call<HotelDetailResponse>
}