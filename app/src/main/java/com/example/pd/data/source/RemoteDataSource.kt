package com.example.pd.data.source

import com.example.pd.data.source.remote.WhatToReadApi
import com.example.pd.data.source.remote.model.UserResponse
import com.example.pd.data.mapper.AuthorizationDtoMapperImpl
import com.example.pd.domain.model.AuthorizationDtoModel
import retrofit2.Response

class RemoteDataSource(private val wtrApi: WhatToReadApi) {
    
    suspend fun login(authorizationDtoModel: AuthorizationDtoModel): Response<Void> {
        val loginRequest =
            AuthorizationDtoMapperImpl.mapAuthorizationDtoModelToRequest(authorizationDtoModel)
        return wtrApi.login(loginRequest)
    }
    
    suspend fun getUser(token: String): Response<UserResponse> {
        return wtrApi.getUser(token)
    }
    
}