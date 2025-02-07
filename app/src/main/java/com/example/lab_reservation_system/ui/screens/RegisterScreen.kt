package com.example.lab_reservation_system.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import com.example.lab_reservation_system.ui.viewmodel.AuthViewModel

@Composable
fun SignUpScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    var userId by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showMessage by remember { mutableStateOf(false) }

    // Define the showToast function that will show the toast
    val context = LocalContext.current
    val showToast: (String) -> Unit = { message ->
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "SIGN UP", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(48.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = 2.dp
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text("User ID", fontSize = 16.sp, color = Color.Black)
                OutlinedTextField(value = userId, onValueChange = { userId = it }, modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(16.dp))

                Text("Email", fontSize = 16.sp, color = Color.Black)
                OutlinedTextField(value = email, onValueChange = { email = it }, modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(16.dp))

                Text("Password", fontSize = 16.sp, color = Color.Black)
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        // Call signUp and pass showToast to display success or failure message
                        authViewModel.signUp(userId, email, password, showToast)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF41B6A6))
                ) {
                    Text("Sign Up", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                }
            }
        }
    }

    if (showMessage) {
        Text(authViewModel.signUpMessage, color = Color.Red, fontSize = 14.sp, modifier = Modifier.padding(top = 8.dp))
    }
}
