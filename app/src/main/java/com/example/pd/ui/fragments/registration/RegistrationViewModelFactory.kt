package com.example.pd.ui.fragments.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.AuthorizationRepository
import com.example.pd.domain.repository.UserRepository

class RegistrationViewModelFactory(
    private val authorizationRepository: AuthorizationRepository,
    private val userRepository: UserRepository
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java))
            return RegistrationViewModel(authorizationRepository, userRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}