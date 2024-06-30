package com.example.mybank.domain.repository.movements

import com.example.mybank.domain.model.Movement
import com.example.mybank.domain.util.AppResult
import javax.inject.Inject

interface MovementsRepository{
    suspend fun saveMovementIdLocal(movementId: Int): AppResult<Unit>
    suspend fun getMovementIdLocal(): AppResult<Int>

}