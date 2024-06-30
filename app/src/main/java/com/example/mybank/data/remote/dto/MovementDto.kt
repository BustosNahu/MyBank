package com.example.mybank.data.remote.dto

import com.example.mybank.domain.model.Movement

data class MovementDto(
    val id: Int = 0,
    val amount: Double = 0.0,
    val typeOfMovement: String = "",
    val date: String = "",
    val description: String = "",
) {
    fun toModel(): Movement =
        Movement(
            id = id,
            amount = amount,
            typeOfMovement = typeOfMovement,
            date = date,
            description = description,
        )

}