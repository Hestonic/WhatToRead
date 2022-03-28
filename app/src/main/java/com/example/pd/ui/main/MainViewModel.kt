package com.example.pd.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.Repository
import com.example.pd.ui.mapper.UiMapper
import com.example.pd.ui.model.UiModel
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val itemsLiveData: MutableLiveData<UiModel> = MutableLiveData()

    fun init() {
        viewModelScope.launch {
            repository.getWtr()?.let {
                itemsLiveData.postValue(UiMapper.map(it))
            }
        }
    }
}