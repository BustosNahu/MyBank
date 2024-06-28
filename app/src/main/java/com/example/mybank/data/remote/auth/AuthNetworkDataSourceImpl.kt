package com.example.mybank.data.remote.auth

import com.example.mybank.domain.useCases.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class AuthNetworkDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthNetworkDataSource {


    override suspend fun login(email: String, password: String): AuthResult {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            AuthResult.Success
        }catch (e: FirebaseAuthInvalidCredentialsException){
            AuthResult.Failure(AuthResult.Error.INCORRECT_EMAIL_OR_PASSWORD)
        }catch (e: Exception){
            AuthResult.Failure(AuthResult.Error.UNDEFINED_ERROR)
        }
    }




    override suspend fun register(
        name: String,
        surname: String,
        email: String,
        password: String,
        picture: String
    ) : AuthResult  {
        return AuthResult.Success
    }


}