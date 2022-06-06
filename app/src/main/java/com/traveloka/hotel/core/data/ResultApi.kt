package com.traveloka.hotel.core.data

sealed class ResultApi<out T> {
    object Loading : ResultApi<Nothing>()
    object Idle : ResultApi<Nothing>()
    class Success<T>(val data: T?) : ResultApi<T>()
    class Failure(val error: String) : ResultApi<Nothing>()
}