package com.example.mybank.data.remote.user

import android.util.Log
import com.example.mybank.data.remote.dto.UserDto
import com.example.mybank.domain.util.AppResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
): UserRemoteDataSource {
    override suspend fun getUserInfo(): AppResult<UserDto> {
        return try {
            val user = firestore.collection("users")
                .document(firebaseAuth.currentUser?.uid ?: "")
                .get()
                .await()
                .toObject(UserDto::class.java)
            AppResult.Success(user ?: UserDto())
        } catch (e: Exception) {
            Log.d("UserRemoteDataSource", "Error: ${e.message}")
            AppResult.Error(e.message.toString())
        }
    }
}