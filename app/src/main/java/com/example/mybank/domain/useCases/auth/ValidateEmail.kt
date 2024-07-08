package com.example.mybank.domain.useCases.auth

import androidx.core.util.PatternsCompat


class ValidateEmail {
    fun execute(email: String): AuthResult.Error? {
        if (email.isEmpty()) return AuthResult.Error.EMPTY_EMAIL

        if (!PatternsCompat.EMAIL_ADDRESS.matcher(email)
                .matches()
        ) return AuthResult.Error.INVALID_EMAIL

        return null
    }

}