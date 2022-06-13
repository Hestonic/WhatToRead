package com.example.pd.ui.fragments.recommend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RecommendViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecommendViewModel::class.java))
            return RecommendViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}