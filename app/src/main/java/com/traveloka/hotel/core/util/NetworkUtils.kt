package com.traveloka.hotel.core.util

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

object NetworkUtils {

    fun getErrorMessage(jsonString: String = "{\"message\":\"Something Error\"}"): String {
        val jsonObj = JSONObject(jsonString)
        return jsonObj.getString("message")
    }

    fun createJsonRequestBody(vararg params: Pair<String, String>) =
        JSONObject(mapOf(*params)).toString()
            .toRequestBody("application/json; charset=utf-8".toMediaType())
}