package com.example.mybank.domain.useCases.auth

import com.example.mybank.domain.repository.auth.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword,
    private val validateEmptyField: ValidateEmptyField,
) {
    suspend fun invoke (name: String, surname: String, email: String, password: String): AuthResult {
        validateEmptyField.execute(name)?.let { error ->
            return AuthResult.Failure(error)
        }
        validateEmptyField.execute(surname)?.let { error ->
            return AuthResult.Failure(error)
        }

        validateEmail.execute(email)?.let { error ->
            return AuthResult.Failure(error)
        }

        validatePassword.execute(password)?.let { error ->
            return AuthResult.Failure(error)
        }

        return AuthResult.Success
    }
}


