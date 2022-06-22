package com.example.pd.domain.mapper

import com.example.pd.data.source.remote.model.AuthorsResponse
import com.example.pd.data.source.remote.model.GenresResponse
import com.example.pd.domain.model.AuthorsDtoModel
import com.example.pd.domain.model.GenresDtoModel

interface FilterDtoMapper {
    fun mapGenresResponseToDtoModel(genresResponse: GenresResponse): GenresDtoModel
    fun mapAuthorsResponseToDtoModel(authorsResponse: AuthorsResponse): AuthorsDtoModel
    
}