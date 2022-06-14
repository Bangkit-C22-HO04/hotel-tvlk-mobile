package com.traveloka.hotel.core.network

import android.content.Context
import com.traveloka.hotel.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object ApiConfig {

    /**
     * Initialize OkhttpClient with our interceptor
     */
    fun okhttpClient(context: Context): OkHttpClient {
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