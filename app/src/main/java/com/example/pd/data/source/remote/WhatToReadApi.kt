package com.example.pd.data.source.remote

import com.example.pd.data.source.remote.model.*
import com.example.pd.utils.Constants
import retrofit2.Response
import retrofit2.http.*

interface WhatToReadApi {
    
    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): Response<Void>
    
    @POST(Constants.REGISTER_URL)
    suspend fun registration(@Body request: RegistrationRequest): Response<Void>
    
    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET(Constants.USER_URL)
    suspend fun getUser(@Header("Authorization") authorization: String): Response<UserResponse>
    
    @GET(Constants.BOOKS_URL)
    suspend fun getBooks(): Response<BooksResponse>
    
    @GET("/{id}.json")
    suspend fun getBook(@Path("id") id: String): Response<BookResponse>
    
    @GET(Constants.GENRES_URL)
    suspend fun getGenres(): Response<GenresResponse>
    
    @GET(Constants.AUTHORS_URL)
    suspend fun getAuthors(): Response<AuthorsResponse>
    
}