package com.example.mybank.presentation.main.home.components

import com.example.mybank.domain.model.Movement

sealed interface HomeEvents {

    data class OnMovementClicked(val movement: Movement): HomeEvents
    data object ClearState: HomeEvents

}