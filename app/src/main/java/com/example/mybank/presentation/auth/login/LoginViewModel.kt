package com.example.mybank.presentation.auth.login

import com.example.mybank.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(

): BaseViewModel<LoginUiState>(){




    override fun defaultState(): LoginUiState {
        return LoginUiState()
    }
}