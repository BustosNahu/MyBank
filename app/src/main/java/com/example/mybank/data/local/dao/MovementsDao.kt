package com.example.mybank.data.local.dao

import com.example.mybank.domain.util.AppResult


interface MovementsDao {
    fun saveMovementIdLocal(movementId: Int): AppResult<Unit>
    fun getMovementIdLocal(): AppResult<Int>
}