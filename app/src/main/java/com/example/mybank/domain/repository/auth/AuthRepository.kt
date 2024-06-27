package com.example.mybank.domain.repository.auth

import androidx.annotation.Nullable
import com.example.mybank.domain.useCases.auth.LoginResult
import com.example.mybank.domain.util.AppResult

interface AuthRepository {
    suspend fun login(email: String, password: String): AppResult<Nullable>
    suspend fun register(name: String, surname:String, email: String, password: String, picture:String)
}