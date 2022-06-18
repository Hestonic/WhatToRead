package com.example.pd.ui.fragments.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.AuthorizationRepository
import com.example.pd.domain.repository.UserRepository
import com.example.pd.ui.mapper.RegistrationUiMapper
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val authorizationRepository: AuthorizationRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    
    private val _token: MutableLiveData<String> = MutableLiveData()
    val token: LiveData<String> = _token
    
    private val loginFailedChannel = Channel<Boolean>()
    val registrationFailedFlow get() = loginFailedChannel.receiveAsFlow()
    
    fun registration(name: String, email: String, password: String, passwordRepeat: String) {
        viewModelScope.launch {
            try {
                val registrationUiModel =
                    RegistrationUiMapper.mapUiModel(name, email, password, passwordRepeat)
                val receivedToken = authorizationRepository.registration(registrationUiModel)
                _token.postValue(receivedToken)
            } catch (e: Exception) {
                loginFailedChannel.send(true)
                e.printStackTrace()
            }
        }
    }
}