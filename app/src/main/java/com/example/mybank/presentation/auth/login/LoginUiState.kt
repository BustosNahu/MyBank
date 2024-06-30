package com.example.mybank.presentation.auth.login

data class LoginUiState (
    val isError: Boolean = false,
    val error: String = "",
    val isLoading: Boolean = false,
    val isLoginSuccess: Boolean = false,

    //Form
    val email: String = "nbustos.alexander@gmail.com",
    val password: String = "12345678",
)