package com.example.mybank.presentation.main.details

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mybank.core.base.BaseViewModel
import com.example.mybank.domain.repository.movements.MovementsRepository
import com.example.mybank.domain.repository.user.UserRepository
import com.example.mybank.domain.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovementDetailViewModel @Inject constructor(
    private val movementsRepository: MovementsRepository,
    private val userRepository: UserRepository

) : BaseViewModel<MovementDetailUiState>() {

    init {
        getAllData()
    }

    private fun getAllData() {
        viewModelScope.launch {
            val jobs = listOf(
                async { getUserInfo() },
                async { getMovementId() }
            )
            jobs.awaitAll()
        }
    }

    private fun getCurrentMovement() {
        val currentMovement = state.value.user?.listOfMovements?.firstOrNull() {
            it.id == state.value.movementId
        }
        _state.update {
            it.copy(
                movement = currentMovement
            )
        }
    }

    private fun getUserInfo() {
        viewModelScope.launch {
            when (val response = userRepository.getUserInfo()) {
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
                    getCurrentMovement()
                }
            }
        }
    }

    private fun getMovementId() {
        viewModelScope.launch {
            when (val response = movementsRepository.getMovementIdLocal()) {
                is AppResult.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = true
                        )
                    }
                }
                is AppResult.Success -> {
                    Log.d("Movement", "getMovementId: ${response.data}")
                    _state.update {
                        it.copy(
                            isLoading = false,
                            movementId = response.data
                        )
                    }
                }
            }
        }
    }



    override fun defaultState(): MovementDetailUiState = MovementDetailUiState()

}