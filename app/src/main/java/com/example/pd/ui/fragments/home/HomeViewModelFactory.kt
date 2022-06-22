package com.example.pd.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.AuthorizationRepository

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory: ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java))
            return HomeViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}