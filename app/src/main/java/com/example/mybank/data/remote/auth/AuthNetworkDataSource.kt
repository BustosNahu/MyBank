package com.example.mybank.data.remote.auth

import androidx.annotation.Nullable
import com.example.mybank.domain.useCases.auth.LoginResult
import com.example.mybank.domain.util.AppResult

interface AuthNetworkDataSource {
    suspend fun login(email: String, password: String): AppResult<Nullable>
    suspend fun register(name: String, surname: String, email: String, password: String, picture: String): LoginResult
}