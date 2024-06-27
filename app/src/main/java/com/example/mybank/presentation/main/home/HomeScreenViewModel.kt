package com.example.mybank.presentation.main.home

import com.example.mybank.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(


): BaseViewModel<HomeScreenUiState>(){





    override fun defaultState(): HomeScreenUiState {
        return HomeScreenUiState()
    }

}