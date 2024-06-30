package com.example.mybank.data.remote.user

import com.example.mybank.data.remote.dto.UserDto
import com.example.mybank.domain.util.AppResult

interface UserRemoteDataSource {
    suspend fun getUserInfo(): AppResult<UserDto>
}