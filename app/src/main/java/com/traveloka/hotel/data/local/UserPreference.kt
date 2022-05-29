package com.traveloka.hotel.data.local

import android.content.Context
import com.google.android.gms.maps.model.LatLng

interface IUserPreference {
    fun setLocation(value: LatLng)
    fun getLocation(): LatLng
}

class UserPreference {

    class UserPreference(context: Context): IUserPreference {
        companion object {
            private const val PREFS_NAME = "user_pref"
            private const val LOCATION = "location"
            private const val LATITUDE = "latitude"
            private const val LONGITUDE = "longitude"
        }

        private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        override fun setLocation(value: LatLng) {
            val editor = preferences.edit()
            editor.putString(LATITUDE, value.latitude.toString())
            editor.putString(LONGITUDE, value.longitude.toString())
            editor.apply()
        }

        override fun getLocation(): LatLng {
            val latitude = preferences.getString(LATITUDE, "0.0")
            val longitude = preferences.getString(LONGITUDE, "0.0")

            return LatLng(latitude?.toDouble() ?: 0.0, longitude?.toDouble() ?: 0.0)

        }


    }
}