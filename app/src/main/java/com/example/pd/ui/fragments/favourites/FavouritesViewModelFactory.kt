package com.example.pd.ui.fragments.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.Repository

class FavouritesViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavouritesViewModel::class.java))
            return FavouritesViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}