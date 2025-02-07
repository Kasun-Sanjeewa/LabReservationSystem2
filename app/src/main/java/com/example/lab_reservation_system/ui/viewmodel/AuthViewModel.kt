package com.example.lab_reservation_system.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_reservation_system.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val repository = AuthRepository()

    var signUpMessage = ""

    // Updated signUp function with showToast callback
    fun signUp(username: String, email: String, password: String, showToast: (String) -> Unit) {
        viewModelScope.launch {
            repository.signUp(username, email, password) { response ->
                if (response != null) {
                    showToast("Registration Successful") // Show success message
                } else {
                    signUpMessage = "Signup failed!"
                    showToast("Signup failed!") // Show failure message
                }
            }
        }
    }
}
