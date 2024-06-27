package com.example.mybank.data.repository.auth

import androidx.annotation.Nullable
import com.example.mybank.data.remote.auth.AuthNetworkDataSourceImpl
import com.example.mybank.domain.repository.auth.AuthRepository
import com.example.mybank.domain.useCases.auth.LoginResult
import com.example.mybank.domain.util.AppResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authNetworkDataSourceImpl: AuthNetworkDataSourceImpl
): AuthRepository {
    override suspend fun login(email: String, password: String): AppResult<Nullable> {
        return withContext(Dispatchers.IO){
            authNetworkDataSourceImpl.login(email, password)
        }
    }

    override suspend fun register(
        name: String,
        surname: String,
        email: String,
        password: String,
        picture: String
    ) {
//        TODO("Not yet implemented")
    }

}