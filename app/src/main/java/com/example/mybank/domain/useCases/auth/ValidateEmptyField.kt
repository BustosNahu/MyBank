package com.example.mybank.domain.useCases.auth

class ValidateEmptyField {
    fun execute(email: String): AuthResult.Error? {
        if (email.isEmpty()) return AuthResult.Error.EMPTY_FIELD
        return null
    }
}