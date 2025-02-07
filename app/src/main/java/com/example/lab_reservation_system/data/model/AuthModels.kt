package com.example.lab_reservation_system.data.model

data class SignUpRequest(
    val username: String,
    val email: String,
    val password: String
)

data class SignUpResponse(
    val message: String
)
