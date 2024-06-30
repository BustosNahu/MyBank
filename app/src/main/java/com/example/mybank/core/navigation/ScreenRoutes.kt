package com.example.mybank.core.navigation

sealed class ScreenRoutes(val route: String) {
    //Auth
    object LoginScreen: ScreenRoutes("login_screen")
    object RegisterScreen: ScreenRoutes("register_screen")

    //Home
    object HomeScreen: ScreenRoutes("home_screen")
    object MovementDetailScreen: ScreenRoutes("movement_screen")

}