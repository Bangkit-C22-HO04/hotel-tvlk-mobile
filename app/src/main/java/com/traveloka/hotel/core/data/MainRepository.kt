package com.traveloka.hotel.core.data

import com.traveloka.hotel.core.data.local.IUserPreference

class MainRepository(private val userPreference: IUserPreference) {
    fun getToken() = userPreference.fetchAuthToken()
    fun setToken(token: String) = userPreference.saveAuthToken(token)
    fun setCity(city: String) = userPreference.setCityName(city)

    companion object {
        @Volatile
        private var instance: MainRepository? = null

        fun getInstance(
            mUserPreference: IUserPreference
        ): MainRepository = instance ?: synchronized(this) {
            instance ?: MainRepository(mUserPreference)
        }.also { instance = it }
    }
}