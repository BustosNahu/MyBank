package com.example.mybank.data.remote.auth

import androidx.annotation.Nullable
import com.example.mybank.domain.useCases.auth.AuthResult
import com.example.mybank.domain.util.AppResult

interface AuthNetworkDataSource {
    suspend fun login(email: String, password: String): AuthResult
    suspend fun register(name: String, surname: String, email: String, password: String, picture: String): AuthResult
}