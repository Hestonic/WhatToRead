package com.example.pd.data.repository

import com.example.pd.data.mapper.FilterDtoMapperImpl
import com.example.pd.data.source.RemoteDataSource
import com.example.pd.domain.model.AuthorsDtoModel
import com.example.pd.domain.model.GenresDtoModel
import com.example.pd.domain.repository.FilterRepository

class FilterRepositoryImpl(private val remoteDataSource: RemoteDataSource) : FilterRepository {
    
    override suspend fun getGenres(): GenresDtoModel? {
        remoteDataSource.getGenres().let { response ->
            if (response.isSuccessful) {
                response.body()?.let { genresResponse ->
                    return FilterDtoMapperImpl.mapGenresResponseToDtoModel(genresResponse)
                }
            }
            return null
        }
    }
    
    override suspend fun getAuthors(): AuthorsDtoModel? {
        remoteDataSource.getAuthors().let { response ->
            if (response.isSuccessful) {
                response.body()?.let { authorsResponse ->
                    return FilterDtoMapperImpl.mapAuthorsResponseToDtoModel(authorsResponse)
                }
            }
            return null
        }
    }
}