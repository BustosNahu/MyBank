package com.example.mybank.presentation.auth.register

import com.example.mybank.domain.model.Movement

data class RegisterUiState(
    val isError: Boolean = false,
    val isRegisterSuccess: Boolean = false,
    val isLoading: Boolean = false,

    //Form
    val name: String = "",
    val surname: String = "",
    val email: String = "",
    val password: String = "",
    val isCameraLaunch: Boolean = false,
    val photoIdUrl: String = "",

    val stepTwoOfRegistration: Boolean = false,
)