package com.example.mybank.presentation.auth.register

import com.example.mybank.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(


): BaseViewModel<RegisterUiState>(){



    override fun defaultState(): RegisterUiState {
        return RegisterUiState()
    }
}