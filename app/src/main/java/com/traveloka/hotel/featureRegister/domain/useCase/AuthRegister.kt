package com.traveloka.hotel.featureRegister.domain.useCase

import com.traveloka.hotel.featureRegister.domain.IRegisterRepository
import okhttp3.RequestBody

class AuthRegister(private val repository: IRegisterRepository) {
    operator fun invoke(request: RequestBody) = repository.register(request)
}