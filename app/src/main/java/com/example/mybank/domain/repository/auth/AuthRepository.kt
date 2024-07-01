package com.example.mybank.domain.repository.auth

import android.net.Uri
import com.example.mybank.domain.model.User
import com.example.mybank.domain.useCases.auth.AuthResult
import com.example.mybank.domain.util.AppResult

interface AuthRepository {
    suspend fun login(user: User): AuthResult
    suspend fun register(user: User): AuthResult
    suspend fun uploadIdPhoto(uri: Uri): AppResult<String>
    suspend fun logout(): AppResult<Unit>

}