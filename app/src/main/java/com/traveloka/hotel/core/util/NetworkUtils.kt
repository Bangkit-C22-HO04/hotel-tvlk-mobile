package com.traveloka.hotel.core.util

import org.json.JSONObject

object NetworkUtils {

    fun getErrorMessage(jsonString: String?): String {
        val jsonObj = JSONObject(jsonString ?: "{\"message\":\"Something Error\"}")
        return jsonObj.getString("message")
    }
}