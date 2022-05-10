package com.example.pd.ui.fragments.read

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.Repository

class ReadViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReadViewModel::class.java))
            return ReadViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}