package com.example.pd.domain.mapper

import com.example.pd.domain.model.CommentDtoModel
import com.example.pd.ui.model.CommentUiModel

interface CommentDtoMapper {
    fun mapCommentUiModelToDto(commentUiModel: CommentUiModel): CommentDtoModel
}