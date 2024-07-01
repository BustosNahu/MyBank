package com.example.mybank.domain.model

import android.net.Uri
import com.example.mybank.data.remote.dto.MovementDto
import com.example.mybank.data.remote.dto.UserDto

data class User(
    val name: String = "",
    val surname: String = "",
    val email: String = "",
    val password: String = "",
    val photoId: String = "",
    val debitCard: DebitCard = DebitCard(),
    val listOfMovements: List<Movement> = emptyList(),

){
    fun toDto(): UserDto =
        UserDto(
            name = name,
            surname = surname,
            email = email,
            password = password,
            photoId = photoId,
            card = debitCard.toDto(),
            listOfMovements = listOfMovements.map { it.toDto() }
        )
}
