package com.example.mybank.core.di

import android.content.SharedPreferences
import com.example.mybank.data.local.dao.MovementsDao
import com.example.mybank.data.local.dao.MovementsDaoImpl
import com.example.mybank.data.remote.auth.AuthNetworkDataSource
import com.example.mybank.data.remote.auth.AuthNetworkDataSourceImpl
import com.example.mybank.data.remote.user.UserRemoteDataSource
import com.example.mybank.data.remote.user.UserRemoteDataSourceImpl
import com.example.mybank.data.repository.auth.AuthRepositoryImpl
import com.example.mybank.data.repository.movements.MovementsRepositoryImpl
import com.example.mybank.data.repository.user.UserRepositoryImpl
import com.example.mybank.domain.repository.auth.AuthRepository
import com.example.mybank.domain.repository.movements.MovementsRepository
import com.example.mybank.domain.repository.user.UserRepository
import com.example.mybank.domain.useCases.auth.ValidateEmail
import com.example.mybank.domain.useCases.auth.ValidateEmptyField
import com.example.mybank.domain.useCases.auth.ValidatePassword
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideValidateEmail(): ValidateEmail {
        return ValidateEmail()
    }

    @Provides
    @Singleton
    fun provideValidatePassword(): ValidatePassword {
        return ValidatePassword()
    }

    @Provides
    @Singleton
    fun provideValidateEmptyField(): ValidateEmptyField {
        return ValidateEmptyField()
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        authNetworkDataSourceImpl: AuthNetworkDataSourceImpl
    ): AuthRepository {
        return AuthRepositoryImpl(authNetworkDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideAuthNetworkDataSource(
        firebaseAuth: FirebaseAuth,
        firestore: FirebaseFirestore,
        firebaseStorage: FirebaseStorage
    ): AuthNetworkDataSource {
        return AuthNetworkDataSourceImpl(firebaseAuth, firestore, firebaseStorage)
    }

    @Provides
    @Singleton
    fun provideMovementsRepository(
        movementsDao: MovementsDao,
        ): MovementsRepository = MovementsRepositoryImpl(movementsDao)

    @Provides
    @Singleton
    fun provideMovementDaoRepository(sharedPreferences: SharedPreferences):  MovementsDao = MovementsDaoImpl(sharedPreferences)

    @Provides
    @Singleton
    fun provideUserRemoteDataSource(
        firestore: FirebaseFirestore,
        firebaseAuth: FirebaseAuth
    ): UserRemoteDataSource {
        return UserRemoteDataSourceImpl(firestore, firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        userRemoteDataSource: UserRemoteDataSource
    ): UserRepository {
        return UserRepositoryImpl(userRemoteDataSource)
    }

}