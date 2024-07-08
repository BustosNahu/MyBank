package com.example.mybank.domain.useCases.auth

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ValidatePasswordTest {
    private lateinit var validatePassword: ValidatePassword

    @Before
    fun setUp() {
        validatePassword = ValidatePassword()
    }
    @Test
    fun `check empty password`() {
        val password = ""
        val result = validatePassword.execute(password)
        assertEquals(AuthResult.Error.EMPTY_PASSWORD, result)
    }
    @Test
    fun `check weak password`() {
        val password = "1234"
        val result = validatePassword.execute(password)
        assertEquals(AuthResult.Error.WEAK_PASSWORD, result)
    }
    @Test
    fun `is valid password`() {
        val password = "123456"
        val result = validatePassword.execute(password)
        assertNull(result)
    }
}