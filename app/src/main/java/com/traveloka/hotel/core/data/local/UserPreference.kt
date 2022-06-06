package com.traveloka.hotel.core.data.local

import android.content.Context
import com.google.android.gms.maps.model.LatLng

interface IUserPreference {
    fun setLocation(value: LatLng?)
    fun getLocation(): LatLng
    fun saveAuthToken(token: String)
    fun fetchAuthToken(): String?
    fun saveEmail(token: String)
    fun getEmail(): String?
    fun savePassword(token: String)
    fun getPassword(): String?
}


class UserPreference(context: Context) : IUserPreference {
    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val LATITUDE = "latitude"
        private const val LONGITUDE = "longitude"
        const val USER_TOKEN = "user_token"
        const val USER_EMAIL = "user_email"
        const val USER_PASSWORD = "user_password"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun setLocation(value: LatLng?) {
        val editor = preferences.edit()
        editor.putString(LATITUDE, value?.latitude?.toString() ?: "")
        editor.putString(LONGITUDE, value?.longitude?.toString() ?: "")
        editor.apply()
    }

    override fun getLocation(): LatLng {
        val latitude = preferences.getString(LATITUDE, "0.0")
        val longitude = preferences.getString(LONGITUDE, "0.0")

        return LatLng(latitude?.toDouble() ?: 0.0, longitude?.toDouble() ?: 0.0)

    }

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


}
