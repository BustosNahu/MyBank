package com.example.mybank.presentation.main.details

import com.example.mybank.domain.model.Movement
import com.example.mybank.domain.model.User

data class MovementDetailUiState (
    val isError: Boolean = false,
    val isLoading: Boolean = true,

    val movementId: Int? = null,
    val movement: Movement? = null,
    val user: User? = null
)