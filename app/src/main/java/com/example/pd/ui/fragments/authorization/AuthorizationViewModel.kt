package com.example.pd.ui.fragments.authorization

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.AuthorizationRepository
import com.example.pd.domain.repository.UserRepository
import com.example.pd.ui.mapper.AuthorizationUiMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AuthorizationViewModel(
    private val authorizationRepository: AuthorizationRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    
    private val _authorizationToken: MutableLiveData<String> = MutableLiveData()
    val authorizationToken: LiveData<String> = _authorizationToken
    
    private val navigationChannel = Channel<Boolean>()
    val navigationFlow get() = navigationChannel.receiveAsFlow()
    
    private val loginFailedChannel = Channel<Boolean>()
    val loginFailedFlow get() = navigationChannel.receiveAsFlow()
    
    fun login(login: String, password: String) {
        viewModelScope.launch {
            val authorizationUiModel = AuthorizationUiMapper.mapLoginUiModel(login, password)
            try {
                val token = authorizationRepository.login(authorizationUiModel)
                _authorizationToken.postValue(token)
            } catch (e: Exception) {
                loginFailedChannel.send(true)
                e.printStackTrace()
            }
            
        }
    }
    
    fun getUser(token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val getUserIsSuccess = userRepository.getUser(token)
            navigationChannel.send(getUserIsSuccess)
        }
    }
    
}
