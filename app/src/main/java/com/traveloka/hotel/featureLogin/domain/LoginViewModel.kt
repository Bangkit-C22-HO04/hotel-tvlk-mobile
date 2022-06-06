package com.traveloka.hotel.featureLogin.domain

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.traveloka.hotel.common.data.ResultApi
import com.traveloka.hotel.common.util.NetworkUtils
import com.traveloka.hotel.featureLogin.data.LoginRepository
import com.traveloka.hotel.featureLogin.data.model.LoginRequest
import com.traveloka.hotel.featureLogin.data.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _loginState = mutableStateOf<ResultApi<String>?>(null)
    val loginState: State<ResultApi<String>?> = _loginState

    fun setEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun setPassword(newPass: String) {
        _password.value = newPass
    }

    fun login(request: LoginRequest) {
        val body = NetworkUtils.createJsonRequestBody(
            "email" to request.email,
            "password" to request.password
        )
        val res = loginRepository.login(body)
        _loginState.value = ResultApi.Loading

        res.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                _loginState.value = if (response.isSuccessful) {
                    val token = response.body()!!.token
                    ResultApi.Success(token)
                } else {
                    val errorMessage = NetworkUtils.getErrorMessage(response.errorBody()?.string())
                    ResultApi.Failure(errorMessage)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _loginState.value = ResultApi.Failure(t.message.toString())
            }

        })
    }
}