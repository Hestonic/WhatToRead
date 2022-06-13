package com.example.pd.ui.fragments.authorization

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.AuthorizationRepository
import com.example.pd.ui.mapper.AuthorizationUiMapper
import kotlinx.coroutines.launch

class AuthorizationViewModel(private val repository: AuthorizationRepository) : ViewModel() {
    
    private val _authorizationToken: MutableLiveData<String> = MutableLiveData()
    val authorizationToken: LiveData<String> = _authorizationToken
    
    fun login(login: String, password: String) {
        viewModelScope.launch {
            val authorizationUiModel = AuthorizationUiMapper.mapLoginUiModel(login, password)
            repository.login(authorizationUiModel)
        }
    }
    
}
