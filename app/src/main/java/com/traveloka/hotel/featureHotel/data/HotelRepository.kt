package com.traveloka.hotel.featureHotel.data

import com.traveloka.hotel.core.data.local.IUserPreference
import com.traveloka.hotel.core.network.ApiService
import com.traveloka.hotel.featureHotel.data.model.HotelDetailRequest
import com.traveloka.hotel.featureHotel.data.model.HotelListRequest

class HotelRepository(private val apiService: ApiService, private val preference: IUserPreference) {

    fun getHotelList(request: HotelListRequest) = apiService.getHotelRanking(request)
    fun getHotelDetail(request: HotelDetailRequest) = apiService.getHotelDetail(request)
    fun getCityName() = preference.getCityName()

}