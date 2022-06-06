package com.traveloka.hotel.common.domain

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.traveloka.hotel.common.data.MainRepository


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {


    fun setLocation(newLocation: LatLng) {
        mainRepository.setLocation(newLocation)
    }

    fun getLocation() = mainRepository.getLocation()

    fun getToken() = mainRepository.getToken()
    fun setToken(token: String) = mainRepository.setToken(token)
}