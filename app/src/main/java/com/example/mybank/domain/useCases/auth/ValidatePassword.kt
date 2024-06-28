package com.example.mybank.domain.useCases.auth


class ValidatePassword  {

    fun execute(password: String): AuthResult.Error? {
        if (password.isEmpty()) return AuthResult.Error.EMPTY_PASSWORD

        if (password.length <= 5) return AuthResult.Error.WEAK_PASSWORD

        return null
    }

}