package com.traveloka.hotel.featureHotel.domain

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.traveloka.hotel.core.data.ResultApi
import com.traveloka.hotel.core.util.NetworkUtils
import com.traveloka.hotel.featureHotel.data.HotelRepository
import com.traveloka.hotel.featureHotel.data.model.HotelListRequest
import com.traveloka.hotel.featureHotel.data.model.HotelListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(private val repository: HotelRepository) : ViewModel() {


    private val _city = mutableStateOf("")
    val city: State<String> = _city

    fun setCity(city: String) {
        _city.value = city
    }

    private val _travelPurpose = mutableStateOf("")
    val travelPurpose: State<String> = _travelPurpose

    fun setTravelPurpose(newTravelPurpose: String) {
        _travelPurpose.value = newTravelPurpose
    }

    private val _hotelListState = mutableStateOf<ResultApi<HotelListResponse>>(ResultApi.Idle)
    val hotelListState: State<ResultApi<HotelListResponse>> = _hotelListState

    fun getHotelList(request: HotelListRequest) {
        val res = repository.getHotelList(request)
        _hotelListState.value = ResultApi.Loading

        res.enqueue(object : Callback<HotelListResponse> {
            override fun onResponse(
                call: Call<HotelListResponse>,
                response: Response<HotelListResponse>
            ) {
                _hotelListState.value = if (response.isSuccessful) {
                    val data = response.body()!!
                    ResultApi.Success(data)
                } else {
                    val errorMessage = NetworkUtils.getErrorMessage(response.errorBody()?.string())
                    ResultApi.Failure(errorMessage)
                }
            }

            override fun onFailure(call: Call<HotelListResponse>, t: Throwable) {
                _hotelListState.value = ResultApi.Failure(t.message.toString())
            }

        })
    }

    fun getCity() = repository.getCityName()
}