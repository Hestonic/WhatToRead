package com.example.pd.domain.repository

import com.example.pd.ui.model.AuthorizationUiModel
import retrofit2.Response

interface AuthorizationRepository {
    suspend fun login(authorizationUiModel: AuthorizationUiModel): String
    suspend fun register()
}