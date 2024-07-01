package com.example.mybank.data.remote.dto

import com.example.mybank.domain.model.User


data class UserDto(
    val name: String = "",
    val surname: String = "",
    val email: String = "",
    val password: String? = null,
    val photoId: String = "",
    val card: DebitCardDto = DebitCardDto(),
    val listOfMovements: List<MovementDto> = listOf(
        MovementDto(
            id = 2,
            amount = 50.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Uber ride"
        ),
        MovementDto(
            id = 1,
            amount = 100.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Salary deposit"
        ),
        MovementDto(
            id = 2,
            amount = 50.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Uber ride"
        ),
        MovementDto(
            id = 1,
            amount = 100.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Salary deposit"
        ),
        MovementDto(
            id = 2,
            amount = 50.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Uber ride"
        ),
        MovementDto(
            id = 1,
            amount = 100.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Salary deposit"
        ),
        MovementDto(
            id = 2,
            amount = 50.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Uber ride"
        ),
        MovementDto(
            id = 2,
            amount = 50.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Uber ride"
        ),
        MovementDto(
            id = 1,
            amount = 1000.0,
            typeOfMovement = "Transfer",
            date = "2024-06-30",
            description = "Salary deposit"
        ),
    ),
) {
    fun toModel(): User =
        User(
            name = name,
            surname = surname,
            email = email,
            password = password ?: "",
            photoId = photoId,
            debitCard = card.toModel(),
            listOfMovements = listOfMovements.map { it.toModel() }
        )

}