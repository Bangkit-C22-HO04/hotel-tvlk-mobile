package com.traveloka.hotel.core.domain

import androidx.lifecycle.ViewModel
import com.traveloka.hotel.core.data.MainRepository


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {


    fun setCity(city: String) {
        mainRepository.setCity(city)
    }

    fun getToken() = mainRepository.getToken()
    fun setToken(token: String) = mainRepository.setToken(token)
}