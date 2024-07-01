package com.example.mybank.presentation.main.home

import com.example.mybank.domain.model.Movement
import com.example.mybank.domain.model.User

data class HomeUiState (
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val isUserLoggedOut: Boolean = false,
    val selectedMovement: Movement? = null,
    val isSelectedMovementIdSaved: Boolean = false,
    val user: User? = null,
)