package com.example.pd.data.source.remote

import com.example.pd.data.source.remote.model.LoginRequest
import com.example.pd.data.source.remote.model.UserResponse
import com.example.pd.utils.Constants
import retrofit2.Response
import retrofit2.http.*


interface WhatToReadApi {
    
    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): Response<Void>
    
    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET(Constants.USER_URL)
    suspend fun getUser(@Header("Authorization") authorization: String): Response<UserResponse>
    
    /*@POST(Constants.REGISTER_URL)
    suspend fun register(): Response<UserResponse>*/
    
}