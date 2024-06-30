package com.example.mybank.data.remote.auth

import com.example.mybank.data.remote.dto.UserDto
import com.example.mybank.domain.useCases.auth.AuthResult

interface AuthNetworkDataSource {
    suspend fun login(userDto: UserDto): AuthResult
    suspend fun register(userDto: UserDto): AuthResult
}