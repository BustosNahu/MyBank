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

    //test
    val movements: List<Movement> = listOf(
        Movement(
            id = 2,
            amount = 50.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Uber ride"
        ),
        Movement(
            id = 1,
            amount = 100.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Salary deposit"
        ),
        Movement(
            id = 2,
            amount = 50.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Uber ride"
        ),
        Movement(
            id = 1,
            amount = 100.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Salary deposit"
        ),
        Movement(
            id = 2,
            amount = 50.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Uber ride"
        ),
        Movement(
            id = 1,
            amount = 100.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Salary deposit"
        ),
        Movement(
            id = 2,
            amount = 50.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Uber ride"
        ),
        Movement(
            id = 2,
            amount = 50.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Uber ride"
        ),
        Movement(
            id = 1,
            amount = 1000.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Salary deposit"
        ),
    )
)