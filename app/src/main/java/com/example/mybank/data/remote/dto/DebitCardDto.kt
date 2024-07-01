package com.example.mybank.data.remote.dto

import com.example.mybank.domain.model.DebitCard

data class DebitCardDto (
    val balance: Double = 0.0,
    val cardNumber: String = "",
    val expirationDate: String = "",
    val cvv: String = ""
){
    fun toModel() = DebitCard(
        balance = balance,
        cardNumber = cardNumber,
        expirationDate = expirationDate,
        cvv = cvv
    )
}