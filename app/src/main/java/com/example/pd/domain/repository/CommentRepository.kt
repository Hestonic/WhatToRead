package com.example.pd.domain.repository

import com.example.pd.ui.model.CommentUiModel

interface CommentRepository {
    suspend fun publishComment(commentUiModel: CommentUiModel)
}