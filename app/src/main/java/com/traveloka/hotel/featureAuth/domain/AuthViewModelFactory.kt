package com.traveloka.hotel.featureAuth.domain

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.traveloka.hotel.di.Injection
import com.traveloka.hotel.featureAuth.data.AuthRepository

class AuthViewModelFactory private constructor(private val authRepository: AuthRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    companion object {
        @Volatile
        private var instance: AuthViewModelFactory? = null

        fun getInstance(context: Context): AuthViewModelFactory = instance ?: synchronized(this) {
            instance ?: AuthViewModelFactory(
                Injection.provideAuthRepository(
                    context
                )
            )
        }.also { instance = it }
    }
}