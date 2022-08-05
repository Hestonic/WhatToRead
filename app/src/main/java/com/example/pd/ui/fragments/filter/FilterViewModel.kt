package com.example.pd.ui.fragments.filter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.FilterRepository
import com.example.pd.ui.mapper.FilterUiMapper
import com.example.pd.ui.model.FilterUiModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class FilterViewModel(private val filterRepository: FilterRepository) : ViewModel() {
    
    private val _filterLiveData: MutableLiveData<List<FilterUiModel>> = MutableLiveData()
    val filterLiveData: LiveData<List<FilterUiModel>> get() = _filterLiveData
    
    private val getFilterFailedChannel = Channel<String>()
    val getFilterFailedFlow get() = getFilterFailedChannel.receiveAsFlow()
    
    fun getFilter() {
        viewModelScope.launch {
            try {
                val authorsDtoModel = filterRepository.getAuthors()
                val genresDtoModel = filterRepository.getGenres()
                if (authorsDtoModel != null && genresDtoModel != null) {
                    val filterUiModel =
                        FilterUiMapper.mapFilterUiModel(authorsDtoModel, genresDtoModel)
                    _filterLiveData.postValue(filterUiModel)
                } else {
                    getFilterFailedChannel.send("Ошибка соединения с сервером")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                getFilterFailedChannel.send("Ошибка соединения с сервером")
            }
        }
    }
}