package com.example.pd.data.api

import retrofit2.http.GET

// TODO: Подключить Api
interface WtrApi {
    @GET("")
    suspend fun getWtr(): WtrResponse
}