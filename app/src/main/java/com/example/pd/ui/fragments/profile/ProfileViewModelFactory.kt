package com.example.pd.ui.fragments.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.UserRepository

class ProfileViewModelFactory(private val userRepository: UserRepository) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java))
            return ProfileViewModel(userRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}