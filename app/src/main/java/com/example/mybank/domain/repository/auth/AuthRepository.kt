package com.example.mybank.domain.repository.auth

import com.example.mybank.domain.useCases.auth.AuthResult

interface AuthRepository {
    suspend fun login(email: String, password: String): AuthResult
    suspend fun register(name: String, surname:String, email: String, password: String, picture:String): AuthResult
}