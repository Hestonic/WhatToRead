package com.example.pd.ui.mapper

import com.example.pd.ui.model.CommentUiModel

object CommentUiMapper {
    fun initUiModel(bookId: String, rating: Int, comment: String) =
        CommentUiModel(bookId = bookId, rating = rating, comment = comment)
}