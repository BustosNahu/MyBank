package com.example.mybank.domain.useCases.auth

import androidx.annotation.Nullable
import com.example.mybank.domain.model.User
import com.example.mybank.domain.repository.auth.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword,
    private val authRepository: AuthRepository
) {
    suspend fun invoke (email: String, password: String): AuthResult {
        validateEmail.execute(email)?.let { error ->
            return AuthResult.Failure(error)
        }

       validatePassword.execute(password)?.let { error ->
            return AuthResult.Failure(error)
        }

        return authRepository.login(User(email = email, password = password))
    }

}