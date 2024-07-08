package com.example.mybank.domain.useCases.auth

import org.junit.Assert.assertEquals
import org.junit.Test


class ValidateEmptyFieldTest {

    @Test
    fun `test if is empty`() {
        val validateEmptyField = ValidateEmptyField()
        val result = validateEmptyField.execute("")
        assertEquals(AuthResult.Error.EMPTY_FIELD, result)
    }
}