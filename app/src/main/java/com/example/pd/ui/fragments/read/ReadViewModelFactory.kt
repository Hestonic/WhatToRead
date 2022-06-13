package com.example.pd.ui.fragments.read

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ReadViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReadViewModel::class.java))
            return ReadViewModel() as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}