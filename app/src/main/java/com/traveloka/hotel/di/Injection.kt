package com.traveloka.hotel.di

import android.content.Context
import com.traveloka.hotel.data.api.ApiConfig
import com.traveloka.hotel.data.local.UserPreference
import com.traveloka.hotel.data.repository.LoginRepository
import com.traveloka.hotel.data.repository.MainRepository
import com.traveloka.hotel.data.repository.RegisterRepository

object Injection {
    fun provideMainRepository(context: Context): MainRepository {
        val mUserPreference = UserPreference.UserPreference(context)
        return MainRepository.getInstance(mUserPreference)
    }

    fun provideLoginRepository(context: Context): LoginRepository {
        val apiService = ApiConfig.getApiService(context)
        return LoginRepository.getInstance(apiService)
    }

    fun provideRegisterRepository(context: Context): RegisterRepository {
        val apiService = ApiConfig.getApiService(context)
        return RegisterRepository.getInstance(apiService)
    }
}