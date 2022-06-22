package com.example.pd.data.mapper

import com.example.pd.data.source.remote.model.AuthorsResponse
import com.example.pd.data.source.remote.model.GenresResponse
import com.example.pd.domain.mapper.FilterDtoMapper
import com.example.pd.domain.model.AuthorsDtoModel
import com.example.pd.domain.model.GenresDtoModel

object FilterDtoMapperImpl : FilterDtoMapper {
    override fun mapGenresResponseToDtoModel(genresResponse: GenresResponse): GenresDtoModel =
        with(genresResponse) { GenresDtoModel(genres) }
    
    override fun mapAuthorsResponseToDtoModel(authorsResponse: AuthorsResponse): AuthorsDtoModel =
        with(authorsResponse) { AuthorsDtoModel((authors)) }
}