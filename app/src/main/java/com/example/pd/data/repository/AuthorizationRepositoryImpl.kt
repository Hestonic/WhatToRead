package com.example.pd.data.repository

import android.util.Log
import com.example.pd.data.mapper.AuthorizationDtoMapperImpl
import com.example.pd.data.source.RemoteDataSource
import com.example.pd.domain.repository.AuthorizationRepository
import com.example.pd.ui.model.AuthorizationUiModel

class AuthorizationRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : AuthorizationRepository {
    
    override suspend fun login(authorizationUiModel: AuthorizationUiModel): String {
        val authorizationDtoModel =
            AuthorizationDtoMapperImpl.mapAuthorizationUiModelToDto(authorizationUiModel)
        val response = remoteDataSource.login(authorizationDtoModel)
        return if (response.isSuccessful) {
            val token = response.headers()["Authorization"]
            Log.d("response_tag_success", token ?: "Empty")
            token ?: ""
        } else {
            Log.d("response_tag_error", response.errorBody().toString())
            ""
        }
        
    }
    
    
    override suspend fun register() {
    
    }
}