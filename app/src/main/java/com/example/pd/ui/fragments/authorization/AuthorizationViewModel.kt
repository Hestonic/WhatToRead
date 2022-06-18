package com.example.pd.ui.fragments.authorization

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.AuthorizationRepository
import com.example.pd.domain.repository.UserRepository
import com.example.pd.ui.mapper.AuthorizationUiMapper
import com.example.pd.ui.model.AuthorizationUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AuthorizationViewModel(
    private val authorizationRepository: AuthorizationRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    
    private val _token: MutableLiveData<String?> = MutableLiveData()
    val token: LiveData<String?> = _token
    
    private val loginFailedChannel = Channel<Boolean>()
    val loginFailedFlow get() = loginFailedChannel.receiveAsFlow()
    
    fun login(login: String, password: String) {
        viewModelScope.launch {
            try {
                val authorizationUiModel = AuthorizationUiMapper.mapUiModel(login, password)
                val receivedToken = authorizationRepository.login(authorizationUiModel)
                _token.postValue(receivedToken)
            } catch (e: Exception) {
                loginFailedChannel.send(true)
                e.printStackTrace()
            }
        }
    }
    
}
