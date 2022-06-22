package com.example.pd.ui.fragments.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.BooksRepository

class SearchViewModelFactory(private val booksRepository: BooksRepository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java))
            return SearchViewModel(booksRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}