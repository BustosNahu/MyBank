package com.example.mybank.domain.useCases.auth


class ValidateEmail {
    fun execute(email: String): AuthResult.Error? {
        if (email.isEmpty()) return AuthResult.Error.EMPTY_EMAIL

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches()
        ) return AuthResult.Error.INVALID_EMAIL

        return null
    }

}