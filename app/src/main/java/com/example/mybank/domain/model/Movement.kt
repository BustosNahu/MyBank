package com.example.mybank.domain.model

import com.example.mybank.data.remote.dto.MovementDto

data class Movement(
    val id: Int,
    val amount: Double,
    val typeOfMovement: String,
    val date: String,
    val description: String,
){
    fun toDto(): MovementDto =
        MovementDto(
            id = id,
            amount = amount,
            typeOfMovement = typeOfMovement,
            date = date,
            description = description,
        )
}
