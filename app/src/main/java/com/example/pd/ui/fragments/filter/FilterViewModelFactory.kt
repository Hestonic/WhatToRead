package com.example.pd.ui.fragments.filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FilterViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilterViewModel::class.java))
            return FilterViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}