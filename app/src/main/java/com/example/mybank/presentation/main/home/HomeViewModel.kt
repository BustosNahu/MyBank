package com.example.mybank.presentation.main.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mybank.core.base.BaseViewModel
import com.example.mybank.domain.model.Movement
import com.example.mybank.domain.repository.movements.MovementsRepository
import com.example.mybank.domain.repository.user.UserRepository
import com.example.mybank.domain.util.AppResult
import com.example.mybank.presentation.main.home.components.HomeEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movementsRepository: MovementsRepository,
    private val userRepository: UserRepository
): BaseViewModel<HomeUiState>(){

    init {
        getAllData()
    }

    private fun getAllData() {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch {
            when(val response = userRepository.getUserInfo()){
                is AppResult.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = true
                        )

                    }
                }
                is AppResult.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            user = response.data
                        )
                    }
                }
            }
        }
    }

    fun handleEvent(event: HomeEvents){
        when(event){
            is HomeEvents.OnMovementClicked -> saveMovementToLocalState(event.movement)
            HomeEvents.ClearState -> resetNavigationState()
        }

    }

    private fun resetNavigationState() {
        _state.update {
            it.copy(
                isSelectedMovementIdSaved = false
            )
        }
    }

    private fun saveMovementToLocalState(movement: Movement) {
        _state.update {
            it.copy(
                selectedMovement = movement
            )
        }
        viewModelScope.launch {
            val result = movementsRepository.saveMovementIdLocal(movement.id)
            when(result){
                is AppResult.Error -> {
                    Log.d("HomeViewModel", "Error saving movement to local state")
                }
                is AppResult.Success -> {
                    Log.d("HomeViewModel", "Movement saved to local state")
                    _state.update {
                        it.copy(
                            isSelectedMovementIdSaved = true
                        )
                    }
                }
            }
        }
    }


    override fun defaultState(): HomeUiState {
        return HomeUiState()
    }

}