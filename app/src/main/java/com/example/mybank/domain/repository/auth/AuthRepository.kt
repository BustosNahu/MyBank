package com.example.mybank.domain.repository.auth

import com.example.mybank.domain.model.User
import com.example.mybank.domain.useCases.auth.AuthResult

interface AuthRepository {
    suspend fun login(user: User): AuthResult
    suspend fun register(user: User): AuthResult
}