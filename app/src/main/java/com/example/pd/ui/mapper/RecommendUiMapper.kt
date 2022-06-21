package com.example.pd.ui.mapper

import com.example.pd.domain.model.BookDtoModel
import com.example.pd.ui.model.RecommendUiModel

object RecommendUiMapper {
    fun mapBooksDtoModelToRecommendUiModel(bookDtoModelList: List<BookDtoModel>): List<RecommendUiModel> =
        bookDtoModelList.map {
            RecommendUiModel(
                id = it.id,
                title = it.title,
                author = it.author,
                genres = it.genres.toString().replace("[", "").replace("]", ""),
                rating = 4.0,
                reviews = 121,
                description = it.description
            
            )
        }
}