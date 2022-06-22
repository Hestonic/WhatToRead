package com.example.pd.data.source

import com.example.pd.data.mapper.AuthorizationDtoMapperImpl
import com.example.pd.data.source.remote.WhatToReadApi
import com.example.pd.data.source.remote.model.*
import com.example.pd.domain.model.AuthorizationDtoModel
import com.example.pd.domain.model.RegistrationDtoModel
import retrofit2.Response

class RemoteDataSource(private val wtrApi: WhatToReadApi) {
    
    suspend fun login(authorizationDtoModel: AuthorizationDtoModel): Response<Void> {
        val loginRequest =
            AuthorizationDtoMapperImpl.mapAuthorizationDtoModelToRequest(authorizationDtoModel)
        return wtrApi.login(loginRequest)
    }
    
    suspend fun registration(registrationDtoModel: RegistrationDtoModel): Response<Void> {
        val registrationRequest =
            AuthorizationDtoMapperImpl.mapRegistrationDtoModelToRequest(registrationDtoModel)
        return wtrApi.registration(registrationRequest)
    }
    
    suspend fun getUser(token: String): Response<UserResponse> {
        return wtrApi.getUser(token)
    }
    
    suspend fun getBooks(): Response<BooksResponse> {
        return wtrApi.getBooks()
    }
    
    suspend fun getBook(id: String): Response<BookResponse> {
        return wtrApi.getBook(id)
    }
    
    suspend fun getGenres(): Response<GenresResponse> {
        return wtrApi.getGenres()
    }
    
    suspend fun getAuthors(): Response<AuthorsResponse> {
        return wtrApi.getAuthors()
    }
    
}