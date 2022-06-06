package com.traveloka.hotel.di

import com.traveloka.hotel.common.data.MainRepository
import com.traveloka.hotel.common.data.local.IUserPreference
import com.traveloka.hotel.common.network.ApiService
import com.traveloka.hotel.featureLogin.data.LoginRepository
import com.traveloka.hotel.featureLogin.domain.ILoginRepository
import com.traveloka.hotel.featureLogin.domain.useCase.AuthLogin
import com.traveloka.hotel.featureLogin.domain.useCase.LoginUseCases
import com.traveloka.hotel.featureRegister.data.RegisterRepository
import com.traveloka.hotel.featureRegister.domain.IRegisterRepository
import com.traveloka.hotel.featureRegister.domain.useCase.AuthRegister
import com.traveloka.hotel.featureRegister.domain.useCase.RegisterUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLoginRepository(apiService: ApiService): ILoginRepository {
        return LoginRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideRegisterRepository(apiService: ApiService): IRegisterRepository {
        return RegisterRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideMainRepository(userPreference: IUserPreference): MainRepository {
        return MainRepository(userPreference)
    }

    @Provides
    @Singleton
    fun provideLoginUseCases(repository: ILoginRepository): LoginUseCases {
        return LoginUseCases(authLogin = AuthLogin(repository))
    }

    @Provides
    @Singleton
    fun provideRegisterUseCases(repository: IRegisterRepository): RegisterUseCases {
        return RegisterUseCases(authRegister = AuthRegister(repository))
    }
}