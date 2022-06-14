package com.traveloka.hotel.featureAuth.data

import com.traveloka.hotel.core.data.local.IUserPreference
import com.traveloka.hotel.core.network.ApiService
import okhttp3.RequestBody

class AuthRepository(private val apiService: ApiService, private val preference: IUserPreference) {

    fun register(request: RequestBody) = apiService.postRegister(request)
    fun login(request: RequestBody) = apiService.postLogin(request)
    fun setToken(token: String) = preference.saveAuthToken(token)

    fun logout() {
        preference.saveAuthToken("")
        preference.setCityName("")
    }
}