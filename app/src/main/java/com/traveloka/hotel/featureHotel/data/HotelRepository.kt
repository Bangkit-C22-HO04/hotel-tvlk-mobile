package com.traveloka.hotel.featureHotel.data

import com.traveloka.hotel.core.data.local.IUserPreference
import com.traveloka.hotel.core.network.ApiService
import okhttp3.RequestBody

class HotelRepository(private val apiService: ApiService, private val preference: IUserPreference) {

    fun getHotelList(request: RequestBody) = apiService.getHotelRanking(request)
    fun getHotelDetail(request: RequestBody) = apiService.getHotelDetail(request)

    companion object {
        @Volatile
        private var instance: HotelRepository? = null

        fun getInstance(
            apiService: ApiService, preference: IUserPreference
        ): HotelRepository = instance ?: synchronized(this) {
            instance ?: HotelRepository(apiService, preference)
        }.also { instance = it }
    }
}