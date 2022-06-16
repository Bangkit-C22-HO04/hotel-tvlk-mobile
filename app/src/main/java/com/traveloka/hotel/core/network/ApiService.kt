package com.traveloka.hotel.core.network

import com.traveloka.hotel.featureAuth.data.model.login.LoginRequest
import com.traveloka.hotel.featureAuth.data.model.login.LoginResponse
import com.traveloka.hotel.featureAuth.data.model.register.RegisterRequest
import com.traveloka.hotel.featureAuth.data.model.register.RegisterResponse
import com.traveloka.hotel.featureHotel.data.model.HotelDetailRequest
import com.traveloka.hotel.featureHotel.data.model.HotelDetailResponse
import com.traveloka.hotel.featureHotel.data.model.HotelListRequest
import com.traveloka.hotel.featureHotel.data.model.HotelListResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(ApiConstants.LOGIN)
    fun postLogin(@Body request: LoginRequest): Call<LoginResponse>

    @POST(ApiConstants.REGISTER)
    fun postRegister(@Body request: RegisterRequest): Call<RegisterResponse>

    @POST(ApiConstants.HOTEL_RANKING)
    fun getHotelRanking(@Body request: HotelListRequest): Call<HotelListResponse>

    @POST(ApiConstants.HOTEL_DETAIL)
    fun getHotelDetail(@Body request: HotelDetailRequest): Call<HotelDetailResponse>
}