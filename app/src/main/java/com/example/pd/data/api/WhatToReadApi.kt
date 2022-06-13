package com.example.pd.data.api

import com.example.pd.data.api.model.LoginRequest
import com.example.pd.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface WhatToReadApi {
    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): Response<Void>
    
    /*@POST(Constants.REGISTER_URL)
    @FormUrlEncoded
    suspend fun register(): Call<Registration>*/
}