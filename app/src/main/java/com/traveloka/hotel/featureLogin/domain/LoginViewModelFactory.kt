package com.traveloka.hotel.featureLogin.domain

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.traveloka.hotel.di.Injection
import com.traveloka.hotel.featureLogin.data.LoginRepository

class LoginViewModelFactory private constructor(private val loginRepository: LoginRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(loginRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    companion object {
        @Volatile
        private var instance: LoginViewModelFactory? = null

        fun getInstance(context: Context): LoginViewModelFactory = instance ?: synchronized(this) {
            instance ?: LoginViewModelFactory(Injection.provideLoginRepository(context))
        }.also { instance = it }
    }
}