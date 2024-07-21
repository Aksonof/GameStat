package com.example.everdalestat.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.everdalestat.model.GameResultRepository

class GameResultViewModelFactory(private val repository: GameResultRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameResultViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GameResultViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}