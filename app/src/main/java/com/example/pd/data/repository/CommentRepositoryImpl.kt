package com.example.pd.data.repository

import com.example.pd.data.mapper.CommentDtoMapperImpl
import com.example.pd.data.source.RemoteDataSource
import com.example.pd.domain.repository.CommentRepository
import com.example.pd.ui.model.CommentUiModel

class CommentRepositoryImpl(private val remoteDataSource: RemoteDataSource) : CommentRepository {
    
    override suspend fun publishComment(commentUiModel: CommentUiModel) {
        val commentDtoModel = CommentDtoMapperImpl.mapCommentUiModelToDto(commentUiModel)
    }
}