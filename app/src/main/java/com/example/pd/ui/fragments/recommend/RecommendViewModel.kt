package com.example.pd.ui.fragments.recommend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.BooksRepository
import com.example.pd.ui.mapper.RecommendUiMapper
import com.example.pd.ui.model.RecommendUiModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class RecommendViewModel(private val booksRepository: BooksRepository) : ViewModel() {
    
    private val _recommendUiMode: MutableLiveData<List<RecommendUiModel>> = MutableLiveData()
    val recommendUiModel: LiveData<List<RecommendUiModel>> get() = _recommendUiMode
    
    private val getBooksFailedChannel = Channel<String>()
    val getBooksFailedFlow get() = getBooksFailedChannel.receiveAsFlow()
    
    fun getBooks() {
        viewModelScope.launch {
            try {
                booksRepository.getBooks()?.let { booksDtoModel ->
                    val recommendUiModel =
                        RecommendUiMapper.mapBooksDtoModelToRecommendUiModel(booksDtoModel)
                    _recommendUiMode.postValue(recommendUiModel)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                getBooksFailedChannel.send("Ошибка соединения с сервером")
            }
        }
    }
}