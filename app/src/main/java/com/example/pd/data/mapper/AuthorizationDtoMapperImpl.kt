package com.example.pd.data.mapper

import com.example.pd.data.source.remote.model.LoginRequest
import com.example.pd.domain.mapper.AuthorizationDtoMapper
import com.example.pd.domain.model.AuthorizationDtoModel
import com.example.pd.ui.model.AuthorizationUiModel

object AuthorizationDtoMapperImpl : AuthorizationDtoMapper {
    
    override fun mapAuthorizationUiModelToDto(authorizationUiModel: AuthorizationUiModel) =
        with(authorizationUiModel) {
            AuthorizationDtoModel(login, password)
        }
    
    override fun mapAuthorizationDtoModelToRequest(authorizationDtoModel: AuthorizationDtoModel) =
        with(authorizationDtoModel) {
            LoginRequest(login, password, true)
        }
    
}