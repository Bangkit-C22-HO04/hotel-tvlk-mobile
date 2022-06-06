package com.traveloka.hotel.featureRegister.data

import com.traveloka.hotel.common.network.ApiService
import com.traveloka.hotel.featureRegister.domain.IRegisterRepository
import okhttp3.RequestBody

class RegisterRepository(private val apiService: ApiService) : IRegisterRepository {

    override fun register(request: RequestBody) = apiService.postRegister(request)

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