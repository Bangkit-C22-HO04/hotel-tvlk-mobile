package com.traveloka.hotel.di

import android.content.Context
import com.traveloka.hotel.data.local.UserPreference
import com.traveloka.hotel.repository.MainRepository

object Injection {
    fun provideMainRepository(context: Context): MainRepository {
        val mUserPreference = UserPreference.UserPreference(context)
        return MainRepository.getInstance(mUserPreference)
    }
}