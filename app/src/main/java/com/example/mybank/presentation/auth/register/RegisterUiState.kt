package com.example.mybank.presentation.auth.register

data class RegisterUiState (
    val isError: Boolean = false,
    val isLoading: Boolean = false,

    //Form
    val name: String = "",
    val surname: String = "",
    val email: String = "",
    val password: String = "",
)