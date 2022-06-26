package com.example.pd.ui.fragments.comment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pd.domain.repository.CommentRepository

class CommentViewModelFactory(private val commentRepository: CommentRepository) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommentViewModel::class.java))
            return CommentViewModel(commentRepository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}