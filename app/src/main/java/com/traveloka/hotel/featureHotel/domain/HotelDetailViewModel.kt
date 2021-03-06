package com.traveloka.hotel.featureHotel.domain

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.traveloka.hotel.core.data.ResultApi
import com.traveloka.hotel.core.util.NetworkUtils
import com.traveloka.hotel.featureHotel.data.HotelRepository
import com.traveloka.hotel.featureHotel.data.model.HotelDetailRequest
import com.traveloka.hotel.featureHotel.data.model.HotelDetailResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HotelDetailViewModel @Inject constructor(private val hotelRepository: HotelRepository) :
    ViewModel() {
    private val _hotelDetailState = mutableStateOf<ResultApi<HotelDetailResponse>>(ResultApi.Idle)
    val hotelDetailState: State<ResultApi<HotelDetailResponse>> = _hotelDetailState

    fun getHotelDetail(request: HotelDetailRequest) {
        val res = hotelRepository.getHotelDetail(request)
        _hotelDetailState.value = ResultApi.Loading

        res.enqueue(object : Callback<HotelDetailResponse> {
            override fun onResponse(
                call: Call<HotelDetailResponse>,
                response: Response<HotelDetailResponse>
            ) {
                _hotelDetailState.value = if (response.isSuccessful) {
                    val data = response.body()
                    ResultApi.Success(data)
                } else {
                    val errorMessage = NetworkUtils.getErrorMessage(null)
                    ResultApi.Failure(errorMessage)
                }
            }

            override fun onFailure(call: Call<HotelDetailResponse>, t: Throwable) {
                _hotelDetailState.value = ResultApi.Failure(t.message.toString())
            }

        })
    }
}