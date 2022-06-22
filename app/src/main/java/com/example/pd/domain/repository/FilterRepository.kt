package com.example.pd.domain.repository

import com.example.pd.domain.model.AuthorsDtoModel
import com.example.pd.domain.model.GenresDtoModel
import retrofit2.Response

interface FilterRepository {
    suspend fun getGenres(): GenresDtoModel?
    suspend fun getAuthors(): AuthorsDtoModel?
}