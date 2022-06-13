package com.traveloka.hotel.core.data.local

import android.content.Context

interface IUserPreference {
    fun saveAuthToken(token: String)
    fun fetchAuthToken(): String?
    fun saveEmail(token: String)
    fun getEmail(): String?
    fun savePassword(token: String)
    fun getPassword(): String?
    fun getCityName(): String?
    fun setCityName(city: String)
}


class UserPreference(context: Context) : IUserPreference {
    companion object {
        private const val PREFS_NAME = "user_pref"
        const val USER_TOKEN = "user_token"
        const val USER_EMAIL = "user_email"
        const val USER_PASSWORD = "user_password"
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

    override fun saveEmail(token: String) {
        val editor = preferences.edit()
        editor.putString(USER_EMAIL, token)
        editor.apply()
    }

    override fun getEmail(): String? {
        return preferences.getString(USER_EMAIL, null)
    }

    override fun savePassword(token: String) {
        val editor = preferences.edit()
        editor.putString(USER_PASSWORD, token)
        editor.apply()
    }

    override fun getPassword(): String? {
        return preferences.getString(USER_PASSWORD, null)
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
