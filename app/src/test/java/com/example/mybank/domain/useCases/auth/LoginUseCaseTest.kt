package com.example.mybank.domain.useCases.auth

import com.example.mybank.domain.model.User
import com.example.mybank.domain.repository.auth.AuthRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions



class LoginUseCaseTest {

    private lateinit var loginUseCase: LoginUseCase
    private var validateEmail: ValidateEmail = mockk()
    private var validatePassword: ValidatePassword = mockk()
    private var authRepository: AuthRepository = mockk()

    @Before
    fun setUp() {
        coEvery { authRepository.login(any()) } returns AuthResult.Success
        coEvery { validateEmail.execute(any()) } returns null
        coEvery { validatePassword.execute(any()) } returns null
        loginUseCase = LoginUseCase(validateEmail, validatePassword, authRepository)
    }

    @Test
    fun `invoke with valid email and password should return AuthResult Success`() = runBlocking {
        val email = "test@example.com"
        val password = "testingPassword123"
        val expectedUser = User(email, password)

        validateEmail.execute(email)
        validatePassword.execute(password)
        authRepository.login(expectedUser)
        val result = loginUseCase.invoke(email, password)

        assertEquals(AuthResult.Success, result)
    }

}