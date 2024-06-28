package com.example.mybank.domain.useCases.auth

sealed class AuthResult {
    object Success : AuthResult()

    class Failure(val error: Error) : AuthResult()

    enum class Error {
        UNMATCHED_PASSWORDS,
        INVALID_EMAIL,
        EMPTY_EMAIL,
        WEAK_PASSWORD,
        EMPTY_PASSWORD,
        USER_ALREADY_EXISTS,
        INCORRECT_EMAIL_OR_PASSWORD,
        UNDEFINED_ERROR,
    }
}