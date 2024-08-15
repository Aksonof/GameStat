package com.example.everdalestat.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.everdalestat.model.PlayerResultRepository

class PlayerResultViewModelFactory(private val repository: PlayerResultRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayerResultViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PlayerResultViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}