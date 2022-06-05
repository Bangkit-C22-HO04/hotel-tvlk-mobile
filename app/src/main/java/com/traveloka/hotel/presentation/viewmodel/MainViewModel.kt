package com.traveloka.hotel.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.traveloka.hotel.data.repository.MainRepository


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {


    fun setLocation(newLocation: LatLng) {
        mainRepository.setLocation(newLocation)
    }

    fun getLocation() = mainRepository.getLocation()
}