package com.example.pd.ui.fragments.settings

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.UserRepository
import com.example.pd.ui.mapper.SettingsUiMapper
import com.example.pd.ui.model.SettingsUiModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SettingsViewModel(private val userRepository: UserRepository) :
    ViewModel() {
    
    private val _settingsUiModelLiveData: MutableLiveData<SettingsUiModel> = MutableLiveData()
    val settingsUiModelLiveData: LiveData<SettingsUiModel> = _settingsUiModelLiveData
    
    private val getUserFailedChannel = Channel<String>()
    val getUserFailedFlow get() = getUserFailedChannel.receiveAsFlow()
    
    fun getUser(token: String) {
        viewModelScope.launch {
            try {
                val userDtoModel = userRepository.getUser(token)
                if (userDtoModel == null)
                    getUserFailedChannel.send("Ошибка соединения с сервером")
                else {
                    val settingsUiModel =
                        SettingsUiMapper.mapUserDtoModelToSettingsUiModel(userDtoModel)
                    _settingsUiModelLiveData.postValue(settingsUiModel)
                }
            } catch (e: Exception) {
                Log.d("tag_profile_vm_error", e.toString())
                getUserFailedChannel.send("Ошибка соединения с сервером")
            }
        }
    }
    
}