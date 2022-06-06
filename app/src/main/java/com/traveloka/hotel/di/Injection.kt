package com.traveloka.hotel.di

import android.content.Context
import com.traveloka.hotel.common.data.MainRepository
import com.traveloka.hotel.common.data.local.UserPreference
import com.traveloka.hotel.common.network.ApiConfig
import com.traveloka.hotel.featureLogin.data.LoginRepository
import com.traveloka.hotel.featureRegister.data.RegisterRepository

object Injection {
    fun provideMainRepository(context: Context): MainRepository {
        val mUserPreference = UserPreference(context)
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