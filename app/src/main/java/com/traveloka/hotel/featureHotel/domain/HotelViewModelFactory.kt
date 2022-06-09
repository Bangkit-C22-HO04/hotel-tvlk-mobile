package com.traveloka.hotel.featureHotel.domain

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.traveloka.hotel.di.Injection
import com.traveloka.hotel.featureHotel.data.HotelRepository

class HotelViewModelFactory private constructor(private val hotelRepository: HotelRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HotelViewModel::class.java)) {
            return HotelViewModel(hotelRepository) as T
        } else if (modelClass.isAssignableFrom(HotelDetailViewModel::class.java)) {
            return HotelDetailViewModel(hotelRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    companion object {
        @Volatile
        private var instance: HotelViewModelFactory? = null

        fun getInstance(context: Context): HotelViewModelFactory = instance ?: synchronized(this) {
            instance ?: HotelViewModelFactory(Injection.provideHotelRepository(context))
        }.also { instance = it }
    }
}