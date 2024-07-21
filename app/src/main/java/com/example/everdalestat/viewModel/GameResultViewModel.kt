package com.example.everdalestat.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.everdalestat.model.GameResult
import com.example.everdalestat.model.GameResultRepository
import kotlinx.coroutines.launch

class GameResultViewModel(private val repository: GameResultRepository) : ViewModel() {

    val allGameResults: LiveData<List<GameResult>> = repository.allGameResults.asLiveData()

    fun insert(gameResult: GameResult) = viewModelScope.launch {
        repository.insert(gameResult)
    }

    fun delete(gameResult: GameResult) = viewModelScope.launch {
        repository.delete(gameResult)
    }

}