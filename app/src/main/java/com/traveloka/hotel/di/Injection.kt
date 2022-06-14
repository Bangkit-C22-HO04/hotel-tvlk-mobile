package com.traveloka.hotel.di

import android.content.Context
import com.traveloka.hotel.core.data.MainRepository
import com.traveloka.hotel.core.data.local.UserPreference
import com.traveloka.hotel.core.network.ApiConfig
import com.traveloka.hotel.core.network.ApiConstants
import com.traveloka.hotel.core.network.ApiService
import com.traveloka.hotel.featureAuth.data.AuthRepository
import com.traveloka.hotel.featureHotel.data.HotelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMainRepository(preference: UserPreference): MainRepository =
        MainRepository(preference)

    @Singleton
    @Provides
    fun provideAuthRepository(api: ApiService, preference: UserPreference): AuthRepository =
        AuthRepository(api, preference)

    @Singleton
    @Provides
    fun provideHotelRepository(api: ApiService, preference: UserPreference): HotelRepository =
        HotelRepository(api, preference)

    @Singleton
    @Provides
    fun provideApiServices(@ApplicationContext context: Context): ApiService {
        return Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(
                ApiConfig.okhttpClient(
                    context
                )
            )
            .build()
            .create(ApiService::class.java)
    }
}