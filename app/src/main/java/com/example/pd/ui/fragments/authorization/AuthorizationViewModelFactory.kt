package com.example.pd.ui.fragments.authorization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.AuthorizationRepository

@Suppress("UNCHECKED_CAST")
class AuthorizationViewModelFactory(private val authorizationRepository: AuthorizationRepository) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthorizationViewModel::class.java))
            return AuthorizationViewModel(authorizationRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}