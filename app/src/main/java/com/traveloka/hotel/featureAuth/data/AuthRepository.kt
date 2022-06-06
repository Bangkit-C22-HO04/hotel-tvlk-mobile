package com.traveloka.hotel.featureAuth.data

import com.traveloka.hotel.common.data.local.IUserPreference
import com.traveloka.hotel.common.network.ApiService
import okhttp3.RequestBody

class AuthRepository(private val apiService: ApiService, private val preference: IUserPreference) {

    fun register(request: RequestBody) = apiService.postRegister(request)
    fun login(request: RequestBody) = apiService.postLogin(request)
    fun setToken(token: String) = preference.saveAuthToken(token)
    fun setEmail(email: String) = preference.saveEmail(email)
    fun getEmail() = preference.getEmail()
    fun setPassword(password: String) = preference.savePassword(password)
    fun getPassword() = preference.getPassword()
    fun logout() {
        preference.saveEmail("")
        preference.savePassword("")
        preference.saveAuthToken("")
        preference.setLocation(null)
    }

    companion object {
        @Volatile
        private var instance: AuthRepository? = null

        fun getInstance(
            apiService: ApiService, preference: IUserPreference
        ): AuthRepository = instance ?: synchronized(this) {
            instance ?: AuthRepository(apiService, preference)
        }.also { instance = it }
    }
}