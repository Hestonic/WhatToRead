package com.example.pd.ui.fragments.authorization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.AuthorizationRepository
import com.example.pd.domain.repository.UserRepository

@Suppress("UNCHECKED_CAST")
class AuthorizationViewModelFactory(
    private val authorizationRepository: AuthorizationRepository,
    private val userRepository: UserRepository
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthorizationViewModel::class.java))
            return AuthorizationViewModel(authorizationRepository, userRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}