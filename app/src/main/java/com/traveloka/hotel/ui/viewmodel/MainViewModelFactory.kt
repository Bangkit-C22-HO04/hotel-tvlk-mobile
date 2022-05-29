package com.traveloka.hotel.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.traveloka.hotel.di.Injection
import com.traveloka.hotel.repository.MainRepository

class MainViewModelFactory private constructor(private val registerRepository: MainRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(registerRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    companion object {
        @Volatile
        private var instance: MainViewModelFactory? = null

        fun getInstance(context: Context): MainViewModelFactory = instance ?: synchronized(this) {
            instance ?: MainViewModelFactory(Injection.provideMainRepository(context))
        }.also { instance = it }
    }
}