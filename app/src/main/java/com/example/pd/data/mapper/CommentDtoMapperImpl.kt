package com.example.pd.data.mapper

import com.example.pd.domain.mapper.CommentDtoMapper
import com.example.pd.domain.model.CommentDtoModel
import com.example.pd.ui.model.CommentUiModel

object CommentDtoMapperImpl: CommentDtoMapper {
    override fun mapCommentUiModelToDto(commentUiModel: CommentUiModel) =
        CommentDtoModel(
            bookId = commentUiModel.bookId,
            rating = commentUiModel.rating,
            comment = commentUiModel.comment
        )
}