package com.example.mybank.domain.repository.user

import com.example.mybank.domain.model.User
import com.example.mybank.domain.util.AppResult

interface UserRepository {
    suspend fun getUserInfo(): AppResult<User>
}