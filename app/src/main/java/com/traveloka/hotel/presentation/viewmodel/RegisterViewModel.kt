package com.traveloka.hotel.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.traveloka.hotel.data.ResultApi
import com.traveloka.hotel.data.api.model.RegisterRequest
import com.traveloka.hotel.data.api.model.RegisterResponse
import com.traveloka.hotel.data.repository.RegisterRepository
import com.traveloka.hotel.utils.NetworkUtils.createJsonRequestBody
import com.traveloka.hotel.utils.NetworkUtils.getErrorMessage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterViewModel(private val registerRepository: RegisterRepository) : ViewModel() {


    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _birthDate = mutableStateOf("")
    val birthDate: State<String> = _birthDate

    private val _gender = mutableStateOf("")
    val gender: State<String> = _gender

    private val _registerState = mutableStateOf<ResultApi<String>>(ResultApi.Idle)
    val registerState: State<ResultApi<String>> = _registerState

    fun setEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun setPassword(newPass: String) {
        _password.value = newPass
    }

    fun setBirthDate(newBirthDate: String) {
        _birthDate.value = newBirthDate
    }

    fun setGender(newGender: String) {
        _gender.value = newGender
    }

    fun clearForm() {
        _email.value = ""
        _gender.value = ""
        _birthDate.value = ""
        _password.value = ""
        _birthDate.value = ""
    }

    fun register(request: RegisterRequest) {
        val body = createJsonRequestBody(
            "email" to request.email,
            "password" to request.password,
            "gender" to request.gender,
            "birth_date" to request.birthDate
        )
        val res = registerRepository.register(body)
        _registerState.value = ResultApi.Loading

        res.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                _registerState.value = if (response.isSuccessful) {
                    val message = response.body()!!.message
                    ResultApi.Success(message)
                } else {
                    val errorMessage = getErrorMessage(response.errorBody()?.string())
                    ResultApi.Failure(errorMessage)
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                _registerState.value = ResultApi.Failure(t.message.toString())
            }

        })
    }

}