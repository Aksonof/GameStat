package com.example.everdalestat.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.everdalestat.model.GameRepository
import com.example.everdalestat.model.GameResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GameResultViewModel(private val repository: GameRepository) : ViewModel() {


    private val games = MutableStateFlow<List<GameResult>>(emptyList())

    init {
        viewModelScope.launch {
            games.value = repository.getAllGames()
        }
    }

    fun addGameResult(gameResult: GameResult) {
        viewModelScope.launch {
            repository.insert(gameResult)
            games.value = repository.getAllGames()
        }
    }

    fun deleteGameResult(gameResult: GameResult) {
        viewModelScope.launch {
            repository.delete(gameResult)
            games.value = repository.getAllGames()
        }
    }

}