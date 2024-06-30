package com.example.mybank.data.repository.auth

import com.example.mybank.data.remote.auth.AuthNetworkDataSourceImpl
import com.example.mybank.domain.model.User
import com.example.mybank.domain.repository.auth.AuthRepository
import com.example.mybank.domain.useCases.auth.AuthResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authNetworkDataSourceImpl: AuthNetworkDataSourceImpl
): AuthRepository {
    override suspend fun login(user: User): AuthResult {
        return withContext(Dispatchers.IO){
            authNetworkDataSourceImpl.login(user.toDto())
        }
    }

    override suspend fun register(
        user: User
    ) : AuthResult{
        return withContext(Dispatchers.IO){
            authNetworkDataSourceImpl.register(user.toDto())
        }
    }

}