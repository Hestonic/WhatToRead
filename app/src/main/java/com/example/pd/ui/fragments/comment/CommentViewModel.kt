package com.example.pd.ui.fragments.comment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.CommentRepository
import com.example.pd.ui.mapper.CommentUiMapper
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class CommentViewModel(private val commentRepository: CommentRepository) : ViewModel() {
    
    private val commentFailedChannel = Channel<String>()
    val commentFailedFlow get() = commentFailedChannel.receiveAsFlow()
    
    fun publishComment(bookId: String, rating: Int, comment: String) {
        viewModelScope.launch {
            try {
                val commentUiModel = CommentUiMapper.initUiModel(bookId, rating, comment)
                commentRepository.publishComment(commentUiModel)
            } catch (e: Exception) {
                e.printStackTrace()
                commentFailedChannel.send("Ошибка сети")
            }
            
        }
    }
    
}