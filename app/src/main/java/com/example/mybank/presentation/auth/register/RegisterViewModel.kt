package com.example.mybank.presentation.auth.register

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mybank.core.base.BaseViewModel
import com.example.mybank.domain.repository.auth.AuthRepository
import com.example.mybank.domain.useCases.auth.AuthResult
import com.example.mybank.domain.useCases.auth.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val authRepository: AuthRepository
) : BaseViewModel<RegisterUiState>() {

    fun handleEvents(registerEvents: RegisterEvents) {
        when (registerEvents) {
            is RegisterEvents.OnEmailTextChange -> updateEmailState(registerEvents.email)
            is RegisterEvents.OnNameTextChange -> updateNameState(registerEvents.name)
            is RegisterEvents.OnPasswordTextChange -> updatePasswordState(registerEvents.password)
            is RegisterEvents.OnSurnameTextChange -> updateSurnameState(registerEvents.surname)
            RegisterEvents.ContinueWithRegistration -> checkToContinueWithRegistration()
            is RegisterEvents.OnSavePicAndRegisterUser -> registerUser()
        }
    }

    private fun registerUser() {
        _state.update {
            it.copy(
                isCameraLaunch = false,
                isLoading = true
            )
        }
        viewModelScope.launch {
            val result = authRepository.register(
                state.value.name,
                state.value.surname,
                state.value.email,
                state.value.password,
                "tempPhotoUri"
            )
            when (result) {
                is AuthResult.Failure -> {
                    Log.d("RegisterViewModel", "Error")
                }

                is AuthResult.Success -> {
                    Log.d("RegisterViewModel", "Success")
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isRegisterSuccess = true,
                        )
                    }
                }
            }
        }
    }

    private fun checkToContinueWithRegistration() {
        viewModelScope.launch {
            val result = registerUseCase.invoke(
                state.value.name,
                state.value.surname,
                state.value.email,
                state.value.password
            )
            when (result) {
                is AuthResult.Failure -> {
                    _state.update {
                        it.copy(isError = true)
                    }
                }

                is AuthResult.Success -> {
                    _state.update {
                        it.copy(
                            isCameraLaunch = true,
                            isLoading = true
                        )
                    }
                }
            }
        }
    }

    private fun updateSurnameState(surnameWritten: String) {
        _state.update {
            it.copy(surname = surnameWritten, isError = false)
        }
    }

    private fun updatePasswordState(passwordWritten: String) {
        _state.update {
            it.copy(password = passwordWritten, isError = false)
        }
    }

    private fun updateNameState(nameWritten: String) {
        _state.update {
            it.copy(name = nameWritten, isError = false)
        }
    }

    private fun updateEmailState(emailWritten: String) {
        _state.update {
            it.copy(email = emailWritten, isError = false)
        }
    }


    override fun defaultState(): RegisterUiState {
        return RegisterUiState()
    }

}