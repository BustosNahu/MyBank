package com.example.mybank.data.remote.auth

import android.net.Uri
import com.example.mybank.data.remote.dto.UserDto
import com.example.mybank.domain.useCases.auth.AuthResult
import com.example.mybank.domain.util.AppResult

interface AuthNetworkDataSource {
    suspend fun login(userDto: UserDto): AuthResult
    suspend fun register(userDto: UserDto): AuthResult
    suspend fun uploadIdPhoto(uri : Uri): AppResult<String>
    suspend fun logout(): AppResult<Unit>
}