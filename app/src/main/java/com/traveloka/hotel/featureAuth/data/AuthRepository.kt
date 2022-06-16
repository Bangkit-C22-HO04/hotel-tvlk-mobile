package com.traveloka.hotel.featureAuth.data

import com.traveloka.hotel.core.data.local.IUserPreference
import com.traveloka.hotel.core.network.ApiService
import com.traveloka.hotel.featureAuth.data.model.login.LoginRequest
import com.traveloka.hotel.featureAuth.data.model.register.RegisterRequest

class AuthRepository(private val apiService: ApiService, private val preference: IUserPreference) {

    fun register(request: RegisterRequest) = apiService.postRegister(request)
    fun login(request: LoginRequest) = apiService.postLogin(request)
    fun setToken(token: String) = preference.saveAuthToken(token)

    fun logout() {
        preference.saveAuthToken("")
        preference.setCityName("")
    }
}