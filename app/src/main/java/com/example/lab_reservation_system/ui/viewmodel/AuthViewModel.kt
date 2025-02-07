package com.example.lab_reservation_system.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_reservation_system.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val repository = AuthRepository()

    var signUpMessage = ""

    fun signUp(username: String, email: String, password: String, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            repository.signUp(username, email, password) { response ->
                if (response != null) {
                    signUpMessage = response.message
                    onComplete(true)
                } else {
                    signUpMessage = "Signup failed!"
                    onComplete(false)
                }
            }
        }
    }
}
