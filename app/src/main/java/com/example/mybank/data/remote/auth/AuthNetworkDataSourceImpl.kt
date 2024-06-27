package com.example.mybank.data.remote.auth

import android.util.Log
import androidx.annotation.Nullable
import com.example.mybank.domain.useCases.auth.LoginResult
import com.example.mybank.domain.util.AppResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthNetworkDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthNetworkDataSource {
    override suspend fun login(email: String, password: String): AppResult<Nullable> {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Log.d("AuthNetworkDataSource", "${authResult.user}")

            if (authResult.user != null) {
                Log.d("AuthNetworkDataSource", "User logged in")
                AppResult.Success(Nullable())
            } else {
                AppResult.Error("User not found")
            }
        } catch (e: Exception) {
            AppResult.Error(e.message ?: "An error occurred")
        }
    }

    override suspend fun register(
        name: String,
        surname: String,
        email: String,
        password: String,
        picture: String
    ): LoginResult {
        return LoginResult(successful = true)
    }


}