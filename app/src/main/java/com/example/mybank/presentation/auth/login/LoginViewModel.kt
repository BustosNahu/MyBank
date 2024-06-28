package com.example.mybank.presentation.auth.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mybank.core.base.BaseViewModel
import com.example.mybank.domain.useCases.auth.AuthResult
import com.example.mybank.domain.useCases.auth.LoginUseCase
import com.example.mybank.domain.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginUiState>() {

    fun onEmailTextChange(emailWritten: String) {
        _state.update {
            it.copy(
                email = emailWritten,
                isError = false,
            )
        }
    }

    fun onPasswordTextChange(passwordWritten: String) {
        _state.update {
            it.copy(
                password = passwordWritten,
                isError = false,
            )
        }
    }

    fun validateUserCredentials() {
        viewModelScope.launch {
            val email = _state.value.email
            val password = _state.value.password

            val result = loginUseCase.invoke(email, password)
            Log.d("LoginViewModel", "validateUserCredentials: $result")
            when(result){
                is AuthResult.Failure -> {
                    _state.update {
                        it.copy(
                            isError = true,
                        )
                    }
                }
                is AuthResult.Success -> {
                    _state.update {
                        it.copy(
                            isLoginSuccess = true
                        )
                    }
                }
            }

        }
    }


    override fun defaultState(): LoginUiState {
        return LoginUiState()
    }
}