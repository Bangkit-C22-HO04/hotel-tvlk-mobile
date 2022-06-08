package com.traveloka.hotel.di

import android.content.Context
import com.traveloka.hotel.core.data.MainRepository
import com.traveloka.hotel.core.data.local.UserPreference
import com.traveloka.hotel.core.network.ApiConfig
import com.traveloka.hotel.featureAuth.data.AuthRepository
import com.traveloka.hotel.featureHotel.data.HotelDetailRepository
import com.traveloka.hotel.featureHotel.data.HotelRepository

object Injection {
    fun provideMainRepository(context: Context): MainRepository {
        val mUserPreference = UserPreference(context)
        return MainRepository.getInstance(mUserPreference)
    }

    fun provideAuthRepository(context: Context): AuthRepository {
        val apiService = ApiConfig.getApiService(context)
        val mUserPreference = UserPreference(context)
        return AuthRepository.getInstance(apiService, mUserPreference)
    }

    fun provideHotelRepository(context: Context): HotelRepository {
        val apiService = ApiConfig.getApiService(context)
        val mUserPreference = UserPreference(context)
        return HotelRepository.getInstance(apiService, mUserPreference)
    }

    fun provideHotelDetailRepository(context: Context): HotelDetailRepository {
        val apiService = ApiConfig.getApiService(context)
        return HotelDetailRepository.getInstance(apiService)
    }

}