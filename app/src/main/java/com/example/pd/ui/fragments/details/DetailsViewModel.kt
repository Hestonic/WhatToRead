package com.example.pd.ui.fragments.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.BooksRepository
import com.example.pd.ui.mapper.DetailsUiMapper
import com.example.pd.ui.model.DetailsUiModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class DetailsViewModel(private val booksRepository: BooksRepository) : ViewModel() {
    
    private val _detailsUiModeLiveData: MutableLiveData<DetailsUiModel> = MutableLiveData()
    val detailsUiModelLiveData: LiveData<DetailsUiModel> get() = _detailsUiModeLiveData
    
    private val getBookFailedChannel = Channel<String>()
    val getBookFailedFlow get() = getBookFailedChannel.receiveAsFlow()
    
    fun getBook(id: String) {
        viewModelScope.launch {
            try {
                booksRepository.getBook(id)?.let { bookDtoModel ->
                    val bookUiModel = DetailsUiMapper.mapBookDtoModelToUiModel(bookDtoModel)
                    _detailsUiModeLiveData.postValue(bookUiModel)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                getBookFailedChannel.send("Ошибка соединения с сервером")
            }
            
        }
    }
}