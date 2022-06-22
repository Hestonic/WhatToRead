package com.example.pd.ui.mapper

import com.example.pd.domain.model.BookDtoModel
import com.example.pd.ui.model.SearchUiModel

object SearchUiMapper {
    fun mapBooksDtoModelToSearchUiModel(booksDtoModel: List<BookDtoModel>): List<SearchUiModel> =
        booksDtoModel.map {
            SearchUiModel(
                id = it.id,
                title = it.title,
                author = it.author,
                genres = it.genres.toString().replace("[", "").replace("]", ""),
                rating = 4.0,
                reviews = 24,
                description = it.description,
            )
        }
}