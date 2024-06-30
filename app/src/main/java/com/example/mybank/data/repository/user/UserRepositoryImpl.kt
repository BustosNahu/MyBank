package com.example.mybank.data.repository.user

import com.example.mybank.data.remote.user.UserRemoteDataSource
import com.example.mybank.domain.model.User
import com.example.mybank.domain.repository.user.UserRepository
import com.example.mybank.domain.util.AppResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
): UserRepository {
    override suspend fun getUserInfo(): AppResult<User> {
        return when(val response = userRemoteDataSource.getUserInfo()){
            is AppResult.Success -> {
                AppResult.Success(response.data.toModel())
            }
            is AppResult.Error -> {
                AppResult.Error("Error getting user info request")
            }
        }
    }
}