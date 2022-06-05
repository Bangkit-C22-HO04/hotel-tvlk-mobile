package com.traveloka.hotel.data

sealed class ResultApi<out T> {
    object Loading : ResultApi<Nothing>()
    class Success<T>(val data: T?) : ResultApi<T>()
    class Failure(val error: String) : ResultApi<Nothing>()
}