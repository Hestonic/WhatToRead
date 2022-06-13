package com.example.pd.domain.mapper

import com.example.pd.data.api.model.LoginRequest
import com.example.pd.domain.model.AuthorizationDtoModel
import com.example.pd.ui.model.AuthorizationUiModel

interface AuthorizationDtoMapper {
    fun mapAuthorizationUiModelToDto(authorizationUiModel: AuthorizationUiModel): AuthorizationDtoModel
    fun mapAuthorizationDtoModelToRequest(authorizationDtoModel: AuthorizationDtoModel): LoginRequest
}