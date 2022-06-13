package com.example.pd.ui.fragments.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FavouritesViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavouritesViewModel::class.java))
            return FavouritesViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}