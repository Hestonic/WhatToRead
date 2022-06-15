package com.example.pd.ui.fragments.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.AuthorizationRepository
import com.example.pd.domain.repository.UserRepository
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val authorizationRepository: AuthorizationRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    
    private val _authorizationToken: MutableLiveData<String> = MutableLiveData()
    val authorizationToken: LiveData<String> = _authorizationToken
    
    fun registration () {
        viewModelScope.launch {
        
        }
    }
}