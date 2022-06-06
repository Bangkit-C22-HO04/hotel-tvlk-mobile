package com.traveloka.hotel.common.data

import com.google.android.gms.maps.model.LatLng
import com.traveloka.hotel.common.data.local.IUserPreference

class MainRepository(private val userPreference: IUserPreference) {
    fun setLocation(location: LatLng) = userPreference.setLocation(location)
    fun getLocation() = userPreference.getLocation()
    fun getToken() = userPreference.fetchAuthToken()
    fun setToken(token: String) = userPreference.saveAuthToken(token)

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