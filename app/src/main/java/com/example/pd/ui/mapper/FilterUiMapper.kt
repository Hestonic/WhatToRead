package com.example.pd.ui.mapper

import com.example.pd.domain.model.AuthorsDtoModel
import com.example.pd.domain.model.GenresDtoModel
import com.example.pd.ui.main.FilterInstance
import com.example.pd.ui.model.FilterItem
import com.example.pd.ui.model.FilterUiModel

object FilterUiMapper {
    fun mapFilterUiModel(
        authorsDtoModel: AuthorsDtoModel, genresDtoModel: GenresDtoModel
    ): List<FilterUiModel> {
        return listOf(
            FilterUiModel(
                title = FilterInstance.GENRE_LABEL,
                isVisible = false,
                filterItems = genresDtoModel.genres.map {
                    FilterItem(
                        id = FilterInstance.GENRE_LABEL,
                        name = it
                    )
                },
            ),
            FilterUiModel(
                title = FilterInstance.AUTHOR_LABEL,
                isVisible = false,
                filterItems = authorsDtoModel.authors.map {
                    FilterItem(
                        id = FilterInstance.AUTHOR_LABEL,
                        name = it
                    )
                },
            ),
        )
    }
}