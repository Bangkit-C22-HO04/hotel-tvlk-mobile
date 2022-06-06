package com.traveloka.hotel.featureLogin.data

import com.traveloka.hotel.common.network.ApiService
import com.traveloka.hotel.featureLogin.domain.ILoginRepository
import okhttp3.RequestBody

class LoginRepository(private val apiService: ApiService) : ILoginRepository {

    override fun login(request: RequestBody) = apiService.postLogin(request)

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