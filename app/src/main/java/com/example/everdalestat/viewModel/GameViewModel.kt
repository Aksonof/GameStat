package com.example.everdalestat.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.everdalestat.model.Game
import com.example.everdalestat.model.GameRepository
import kotlinx.coroutines.launch

class GameViewModel (private val repository: GameRepository): ViewModel() {

    val allGames: LiveData<List<Game>> = repository.allGames.asLiveData()

    fun insert(game: Game) = viewModelScope.launch {
        repository.insert(game)
    }

    fun delete(game: Game) = viewModelScope.launch {
        repository.delete(game)
    }

}