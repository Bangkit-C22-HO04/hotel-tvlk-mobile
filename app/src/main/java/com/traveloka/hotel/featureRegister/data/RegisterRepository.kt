package com.traveloka.hotel.featureRegister.data

import com.traveloka.hotel.common.network.ApiService
import okhttp3.RequestBody

class RegisterRepository(private val apiService: ApiService) {

    fun register(request: RequestBody) = apiService.postRegister(request)
    fun login(request: RequestBody) = apiService.postLogin(request)

    companion object {
        @Volatile
        private var instance: RegisterRepository? = null

        fun getInstance(
            apiService: ApiService
        ): RegisterRepository = instance ?: synchronized(this) {
            instance ?: RegisterRepository(apiService)
        }.also { instance = it }
    }
}