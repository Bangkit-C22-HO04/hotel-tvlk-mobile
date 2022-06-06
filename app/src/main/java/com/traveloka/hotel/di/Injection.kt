package com.traveloka.hotel.di

import android.content.Context
import com.traveloka.hotel.common.data.MainRepository
import com.traveloka.hotel.common.data.local.UserPreference
import com.traveloka.hotel.common.network.ApiConfig
import com.traveloka.hotel.featureAuth.data.AuthRepository

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

}