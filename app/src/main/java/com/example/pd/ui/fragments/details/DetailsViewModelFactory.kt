package com.example.pd.ui.fragments.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.BooksRepository

class DetailsViewModelFactory(private val booksRepository: BooksRepository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java))
            return DetailsViewModel(booksRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}