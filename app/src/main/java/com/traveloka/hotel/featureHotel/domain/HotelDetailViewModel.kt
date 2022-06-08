package com.traveloka.hotel.featureHotel.domain

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.traveloka.hotel.core.data.ResultApi
import com.traveloka.hotel.core.util.NetworkUtils
import com.traveloka.hotel.featureHotel.data.HotelDetailRepository
import com.traveloka.hotel.featureHotel.data.model.HotelDetailRequest
import com.traveloka.hotel.featureHotel.data.model.HotelDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HotelDetailViewModel(private val hotelDetailRepository: HotelDetailRepository):ViewModel() {
    private val _hotelDetailState = mutableStateOf<ResultApi<HotelDetailResponse>>(ResultApi.Idle)
    val hotelDetailState: State<ResultApi<HotelDetailResponse>> = _hotelDetailState

    fun getHotelDetail(request: HotelDetailRequest) {
        val body = NetworkUtils.createJsonRequestBody(
            "id" to request.id
        )
        val res = hotelDetailRepository.getHotelDetail(body)
        _hotelDetailState.value = ResultApi.Loading

        res.enqueue(object : Callback<HotelDetailResponse> {
            override fun onResponse(
                call: Call<HotelDetailResponse>,
                response: Response<HotelDetailResponse>
            ) {
                _hotelDetailState.value = if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("HotelDetail", "onResponse: ${data?.data?.name}")
                    ResultApi.Success(data)
                } else {
                    val errorMessage = NetworkUtils.getErrorMessage()
                    ResultApi.Failure(errorMessage)
                }
            }

            override fun onFailure(call: Call<HotelDetailResponse>, t: Throwable) {
                _hotelDetailState.value = ResultApi.Failure(t.message.toString())
            }

        })
    }
}