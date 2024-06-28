package com.example.mybank.presentation.auth.register

sealed interface RegisterEvents {
    data class OnNameTextChange(val name: String) : RegisterEvents
    data class OnSurnameTextChange(val surname: String) : RegisterEvents
    data class OnPasswordTextChange(val password: String) : RegisterEvents
    data class OnEmailTextChange(val email: String) : RegisterEvents

    data object OnRegisterClick : RegisterEvents
}