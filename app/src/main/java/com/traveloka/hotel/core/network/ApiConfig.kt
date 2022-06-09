package com.traveloka.hotel.core.network

import android.content.Context
import com.traveloka.hotel.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiConfig {
    fun getApiService(context: Context): ApiService {

        val retrofit = Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(okhttpClient(context))
            .build()
        return retrofit.create(ApiService::class.java)
    }

    /**
     * Initialize OkhttpClient with our interceptor
     */
    private fun okhttpClient(context: Context): OkHttpClient {
        val loggingInterceptor = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        return OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .addInterceptor(AuthInterceptor(context)).callTimeout(1, TimeUnit.MINUTES)
            .build()
    }
}