package com.example.mybank.domain.useCases.auth

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

private lateinit var validateEmail: ValidateEmail

class ValidateEmailTest {
    @Before
    fun setUp() {
        validateEmail = ValidateEmail()
    }

    @Test
    fun `check if the email it's empty`() {
        val result = validateEmail.execute("")
        assertEquals(AuthResult.Error.EMPTY_EMAIL, result)
    }

    @Test
    fun `check if email is invalid`() {
        val result = validateEmail.execute("test")
        assertEquals(AuthResult.Error.INVALID_EMAIL, result)
    }

    @Test
    fun `check if email is valid`() {
        val result = validateEmail.execute("test@example.com")
        assertNull(result)
    }
}