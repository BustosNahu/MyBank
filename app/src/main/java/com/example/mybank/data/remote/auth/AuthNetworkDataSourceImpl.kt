package com.example.mybank.data.remote.auth

import com.example.mybank.domain.useCases.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class AuthNetworkDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val db: FirebaseFirestore
) : AuthNetworkDataSource {


    override suspend fun login(email: String, password: String): AuthResult {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            AuthResult.Success
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            AuthResult.Failure(AuthResult.Error.INCORRECT_EMAIL_OR_PASSWORD)
        } catch (e: Exception) {
            AuthResult.Failure(AuthResult.Error.UNDEFINED_ERROR)
        }
    }


    override suspend fun register(
        name: String,
        surname: String,
        email: String,
        password: String,
        picture: String
    ): AuthResult {
        return try {
            val userData = hashMapOf(
                "name" to name,
                "surname" to surname,
                "email" to email,
//                "picture" to picture TODO("Add picture to user")
            )
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val uid = firebaseAuth.currentUser?.uid ?: throw Exception("User UID is null")
            db.collection("users")
                .document(uid)
                .set(userData)
                .await()
            AuthResult.Success
        } catch (e: FirebaseAuthUserCollisionException) {
            AuthResult.Failure(AuthResult.Error.USER_ALREADY_EXISTS)
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            AuthResult.Failure(AuthResult.Error.INVALID_EMAIL)
        } catch (e: Exception) {
            AuthResult.Failure(AuthResult.Error.UNDEFINED_ERROR)
        }
    }


}