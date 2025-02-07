package com.example.lab_reservation_system.data

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val message: String, val token: String)

interface AuthApiService {
    @POST("api/auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}
