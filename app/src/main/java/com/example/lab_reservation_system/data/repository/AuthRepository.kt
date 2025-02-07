package com.example.lab_reservation_system.data.repository

import com.example.lab_reservation_system.data.api.AuthApiServiceSignin
import com.example.lab_reservation_system.data.model.SignUpRequest
import com.example.lab_reservation_system.data.model.SignUpResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.56.1:5000/") // Replace with your backend IP
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(AuthApiServiceSignin::class.java)

    fun signUp(username: String, email: String, password: String, onResult: (SignUpResponse?) -> Unit) {
        val request = SignUpRequest(username, email, password)
        val call = api.signUp(request)

        call.enqueue(object : retrofit2.Callback<SignUpResponse> {
            override fun onResponse(
                call: retrofit2.Call<SignUpResponse>,
                response: retrofit2.Response<SignUpResponse>
            ) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else {
                    onResult(null)
                }
            }

            override fun onFailure(call: retrofit2.Call<SignUpResponse>, t: Throwable) {
                onResult(null)
            }
        })
    }
}
