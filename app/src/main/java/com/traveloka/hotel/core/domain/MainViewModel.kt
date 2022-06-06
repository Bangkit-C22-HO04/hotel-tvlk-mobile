package com.traveloka.hotel.core.domain

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.traveloka.hotel.core.data.MainRepository


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {


    fun setLocation(newLocation: LatLng) {
        mainRepository.setLocation(newLocation)
    }

    fun getLocation() = mainRepository.getLocation()
    fun getToken() = mainRepository.getToken()
    fun setToken(token: String) = mainRepository.setToken(token)
}