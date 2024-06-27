package com.example.mybank.domain.useCases.auth

data class LoginResult (
    val successful: Boolean,
    val errorEmailMessage: String? = null,
    val errorPasswordMessage: String? = null
)