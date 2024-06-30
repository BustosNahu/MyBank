package com.example.mybank.domain.model

import com.example.mybank.data.remote.dto.MovementDto
import com.example.mybank.data.remote.dto.UserDto

data class User(
    val name: String = "",
    val surname: String = "",
    val email: String = "",
    val password: String = "",
    val listOfMovements: List<Movement> = emptyList()
){
    fun toDto(): UserDto =
        UserDto(
            name = name,
            surname = surname,
            email = email,
            password = password,
            listOfMovements = listOfMovements.map { it.toDto() }
        )
}
