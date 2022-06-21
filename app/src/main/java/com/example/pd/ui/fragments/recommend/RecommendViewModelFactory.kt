package com.example.pd.ui.fragments.recommend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.BooksRepository

class RecommendViewModelFactory(private val booksRepository: BooksRepository) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecommendViewModel::class.java))
            return RecommendViewModel(booksRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}