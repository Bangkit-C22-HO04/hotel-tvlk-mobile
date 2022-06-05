package com.traveloka.hotel.data.repository

import com.traveloka.hotel.data.api.ApiService
import okhttp3.RequestBody

class LoginRepository(private val apiService: ApiService) {

    fun login(request: RequestBody) = apiService.postLogin(request)

    companion object {
        @Volatile
        private var instance: LoginRepository? = null

        fun getInstance(
            apiService: ApiService
        ): LoginRepository = instance ?: synchronized(this) {
            instance ?: LoginRepository(apiService)
        }.also { instance = it }
    }
}