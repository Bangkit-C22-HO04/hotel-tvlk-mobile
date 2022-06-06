package com.traveloka.hotel.featureLogin.domain.useCase

import com.traveloka.hotel.featureLogin.domain.ILoginRepository
import okhttp3.RequestBody

class AuthLogin(private val repository: ILoginRepository) {
    operator fun invoke(request: RequestBody) = repository.login(request)
}