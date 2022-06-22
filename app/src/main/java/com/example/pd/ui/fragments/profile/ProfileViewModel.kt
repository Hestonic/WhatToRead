package com.example.pd.ui.fragments.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.UserRepository
import com.example.pd.ui.mapper.ProfileUiModelMapper
import com.example.pd.ui.model.ProfileUiModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ProfileViewModel(private val userRepository: UserRepository) : ViewModel() {
    
    private val _profileModel: MutableLiveData<ProfileUiModel> = MutableLiveData()
    val profileModel: LiveData<ProfileUiModel> = _profileModel
    
    private val getUserFailedChannel = Channel<String>()
    val getUserFailedFlow get() = getUserFailedChannel.receiveAsFlow()
    
    fun getUser(token: String) {
        viewModelScope.launch {
            try {
                val userDtoModel = userRepository.getUser(token)
                if (userDtoModel == null)
                    getUserFailedChannel.send("Ошибка соединения с сервером")
                else {
                    val profileUiModel = ProfileUiModelMapper.mapUiModel(userDtoModel)
                    _profileModel.postValue(profileUiModel)
                }
            } catch (e: Exception) {
                Log.d("tag_profile_vm_error", e.toString())
                getUserFailedChannel.send("Ошибка соединения с сервером")
            }
        }
    }
    
}