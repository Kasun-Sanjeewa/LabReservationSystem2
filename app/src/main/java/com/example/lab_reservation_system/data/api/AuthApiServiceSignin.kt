package com.example.lab_reservation_system.data.api

import com.example.lab_reservation_system.data.model.SignUpRequest
import com.example.lab_reservation_system.data.model.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

interface AuthApiServiceSignin {
    @POST("api/auth/signup")
    fun signUp(@Body request: SignUpRequest): Call<SignUpResponse>
}
