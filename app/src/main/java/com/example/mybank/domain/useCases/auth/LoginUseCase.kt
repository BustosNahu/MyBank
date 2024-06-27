package com.example.mybank.domain.useCases.auth

import androidx.annotation.Nullable
import com.example.mybank.domain.repository.auth.AuthRepository
import com.example.mybank.domain.util.AppResult
import javax.inject.Inject

class LoginUseCase
@Inject constructor(
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword,
    private val authRepository: AuthRepository
) {
    suspend fun invoke (email: String, password: String): AppResult<Nullable> {
        val emailResult = validateEmail.execute(email)
        if (!emailResult.successful) {
            return AppResult.Error(emailResult.errorEmailMessage)
        }

        val passwordResult = validatePassword.execute(password)
        if (!passwordResult.successful) {
            return AppResult.Error(passwordResult.errorPasswordMessage)
        }

        return authRepository.login(email, password)
    }

}