package com.traveloka.hotel.core.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

interface IUserPreference {
    fun saveAuthToken(token: String)
    fun fetchAuthToken(): String?
    fun getCityName(): String?
    fun setCityName(city: String)
}

@Singleton
class UserPreference @Inject constructor(@ApplicationContext context: Context) : IUserPreference {
    companion object {
        private const val PREFS_NAME = "user_pref"
        const val USER_TOKEN = "user_token"
        const val USER_CITY = "user_city"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveAuthToken(token: String) {
        val editor = preferences.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    override fun fetchAuthToken(): String? {
        return preferences.getString(USER_TOKEN, null)
    }

    override fun getCityName(): String? {
        return preferences.getString(USER_CITY, null)
    }

    override fun setCityName(city: String) {
        val editor = preferences.edit()
        editor.putString(USER_CITY, city)
        editor.apply()
    }

}
