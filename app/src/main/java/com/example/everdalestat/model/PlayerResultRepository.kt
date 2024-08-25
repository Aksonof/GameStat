package com.example.everdalestat.model

import kotlinx.coroutines.flow.Flow

class PlayerResultRepository(private val playerResultDao: PlayerResultDao) {

    fun allPlayerResults(playerResultId: String): Flow<List<PlayerResult>> =
        playerResultDao.getPlayerResById(playerResultId)


    suspend fun insert(playerResult: PlayerResult) {
        playerResultDao.insert(playerResult)
    }

    suspend fun delete(playerResult: PlayerResult) {
        playerResultDao.delete(playerResult)
    }

    suspend fun edit(playerResult: PlayerResult) {
        playerResultDao.editPlayerResult(playerResult)
    }

}