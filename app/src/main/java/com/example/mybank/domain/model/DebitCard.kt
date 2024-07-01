package com.example.mybank.domain.model

import com.example.mybank.data.remote.dto.DebitCardDto

data class DebitCard(
    val balance: Double = 0.0,
    val cardNumber: String = "",
    val expirationDate: String = "",
    val cvv: String = ""
){
    fun toDto() = DebitCardDto(
        balance = balance,
        cardNumber = cardNumber,
        expirationDate = expirationDate,
        cvv = cvv
    )
}
