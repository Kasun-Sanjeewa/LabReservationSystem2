package com.example.lab_reservation_system.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab_reservation_system.ui.screens.WelcomeScreen
import com.example.lab_reservation_system.ui.screens.LoginScreen
import com.example.lab_reservation_system.ui.screens.SignUpScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { SignUpScreen(navController) }
    }
}
