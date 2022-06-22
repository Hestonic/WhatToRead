package com.example.pd.ui.fragments.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.AuthorizationRepository

class RegistrationViewModelFactory(private val authorizationRepository: AuthorizationRepository) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java))
            return RegistrationViewModel(authorizationRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}