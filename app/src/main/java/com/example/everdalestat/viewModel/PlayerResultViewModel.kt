package com.example.everdalestat.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.everdalestat.model.PlayerResult
import com.example.everdalestat.model.PlayerResultRepository
import kotlinx.coroutines.launch
import java.util.UUID

class PlayerResultViewModel(private val repository: PlayerResultRepository) : ViewModel() {

    private var playerResultId: String? = null

    val playersResult: MutableMap<String, Int> = mutableMapOf()


    fun allPlayersResults(playerResultId: String): LiveData<List<PlayerResult>> =
        repository.allPlayerResults(playerResultId).asLiveData()

    fun insert(playerResult: PlayerResult) = viewModelScope.launch {
        repository.insert(playerResult)
    }

    fun delete(playerResult: PlayerResult) = viewModelScope.launch {
        repository.delete(playerResult)
    }


    fun getOrCreateGameId(): String {
        if (playerResultId == null) {
            playerResultId = UUID.randomUUID().toString()
        }
        return playerResultId!!
    }

    fun getWinner(): Pair<String, Int>? {
        if (playersResult.isEmpty()) return null
        val maxEntry = playersResult.maxByOrNull { it.value }
        return maxEntry?.toPair()
    }

}