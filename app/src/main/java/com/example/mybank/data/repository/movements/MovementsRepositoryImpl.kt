package com.example.mybank.data.repository.movements

import android.content.SharedPreferences
import com.example.mybank.data.local.dao.MovementsDao
import com.example.mybank.domain.repository.movements.MovementsRepository
import com.example.mybank.domain.util.AppResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovementsRepositoryImpl @Inject constructor(
    private val movementsDao: MovementsDao,
): MovementsRepository {
    override suspend fun saveMovementIdLocal(movementId: Int): AppResult<Unit> {
        return withContext(Dispatchers.IO) {
            movementsDao.saveMovementIdLocal(movementId)
        }
    }

    override suspend fun getMovementIdLocal(): AppResult<Int> {
        return withContext(Dispatchers.IO) {
            movementsDao.getMovementIdLocal()
        }
    }


}