package com.example.mybank.core.di

import com.example.mybank.data.remote.auth.AuthNetworkDataSource
import com.example.mybank.data.remote.auth.AuthNetworkDataSourceImpl
import com.example.mybank.data.repository.auth.AuthRepositoryImpl
import com.example.mybank.domain.repository.auth.AuthRepository
import com.example.mybank.domain.useCases.auth.ValidateEmail
import com.example.mybank.domain.useCases.auth.ValidatePassword
import com.google.firebase.auth.FirebaseAuth
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
    fun provideAuthRepository(
        authNetworkDataSourceImpl: AuthNetworkDataSourceImpl
    ): AuthRepository {
        return AuthRepositoryImpl(authNetworkDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideAuthNetworkDataSource(
        firebaseAuth: FirebaseAuth
    ): AuthNetworkDataSource {
        return AuthNetworkDataSourceImpl(firebaseAuth)
    }
}