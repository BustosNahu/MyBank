package com.example.mybank.data.local.dao

import android.content.SharedPreferences
import com.example.mybank.domain.util.AppResult
import javax.inject.Inject

class MovementsDaoImpl @Inject constructor(
    private val cache: SharedPreferences,
) : MovementsDao {
    override fun saveMovementIdLocal(movementId: Int): AppResult<Unit> {
        return try {
            cache.edit().putInt("movementId", movementId).apply()
            AppResult.Success(Unit)
        }catch (e: Exception) {
            AppResult.Error("Error saving movementId", e)
        }
    }

    override fun getMovementIdLocal(): AppResult<Int> {
        return try {
            val id = cache.getInt("movementId", 0)
            AppResult.Success(id)
        }catch (e: Exception) {
            AppResult.Error("Error getting movementId", e)
        }
    }
}
