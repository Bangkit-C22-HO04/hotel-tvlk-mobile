package com.traveloka.hotel.featureHotel.data

import com.traveloka.hotel.core.network.ApiService
import okhttp3.RequestBody

class HotelDetailRepository(private val apiService: ApiService) {

    fun getHotelDetail(request: RequestBody) = apiService.getHotelDetail(request)

    companion object {
        @Volatile
        private var instance: HotelDetailRepository? = null

        fun getInstance(
            apiService: ApiService
        ): HotelDetailRepository = instance ?: synchronized(this) {
            instance ?: HotelDetailRepository(apiService)
        }.also { instance = it }
    }
}