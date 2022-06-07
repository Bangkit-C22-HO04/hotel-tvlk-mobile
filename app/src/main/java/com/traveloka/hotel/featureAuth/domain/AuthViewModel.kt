package com.traveloka.hotel.featureAuth.domain

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.traveloka.hotel.core.data.ResultApi
import com.traveloka.hotel.core.util.NetworkUtils
import com.traveloka.hotel.featureAuth.data.AuthRepository
import com.traveloka.hotel.featureAuth.data.model.login.LoginRequest
import com.traveloka.hotel.featureAuth.data.model.login.LoginResponse
import com.traveloka.hotel.featureAuth.data.model.register.RegisterRequest
import com.traveloka.hotel.featureAuth.data.model.register.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _email = mutableStateOf(authRepository.getEmail() ?: "")
    val email: State<String> = _email

    private val _password = mutableStateOf(authRepository.getPassword() ?: "")
    val password: State<String> = _password

    private val _birthDate = mutableStateOf("")
    val birthDate: State<String> = _birthDate

    private val _gender = mutableStateOf("")
    val gender: State<String> = _gender

    private val _registerState = mutableStateOf<ResultApi<String>>(ResultApi.Idle)
    val registerState: State<ResultApi<String>> = _registerState

    private val _loginState = mutableStateOf<ResultApi<String>?>(null)
    val loginState: State<ResultApi<String>?> = _loginState

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
        _password.value = ""
        _gender.value = ""
        _birthDate.value = ""
    }

    fun register(request: RegisterRequest) {
        val body = NetworkUtils.createJsonRequestBody(
            "email" to request.email,
            "password" to request.password,
            "gender" to request.gender,
            "birth_date" to request.birthDate
        )
        val res = authRepository.register(body)
        _registerState.value = ResultApi.Loading

        res.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                _registerState.value = if (response.isSuccessful) {
                    val message = response.body()!!.message
                    authRepository.setEmail(request.email)
                    authRepository.setPassword(request.password)
                    ResultApi.Success(message)
                } else {
                    val errorMessage =
                        NetworkUtils.getErrorMessage(response.errorBody()?.string() ?: "")
                    ResultApi.Failure(errorMessage)
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                _registerState.value = ResultApi.Failure(t.message.toString())
            }

        })
    }

    fun login(request: LoginRequest) {
        val body = NetworkUtils.createJsonRequestBody(
            "email" to request.email,
            "password" to request.password
        )
        val res = authRepository.login(body)
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
                    val errorMessage =
                        NetworkUtils.getErrorMessage(response.errorBody()?.string() ?: "")
                    ResultApi.Failure(errorMessage)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _loginState.value = ResultApi.Failure(t.message.toString())
            }

        })
    }

    fun setToken(token: String) = authRepository.setToken(token)
    fun logout() = authRepository.logout()
}