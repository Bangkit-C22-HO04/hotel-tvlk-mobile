package com.traveloka.hotel.data.api

import android.content.Context
import android.util.Log
import com.traveloka.hotel.data.local.UserPreference
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor to add auth token to requests
 */
class AuthInterceptor(context: Context) : Interceptor {
    private val userPreference = UserPreference.UserPreference(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request
        userPreference.fetchAuthToken()?.let {
            Log.d("JWT-TOKEN", "intercept: $it")
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}