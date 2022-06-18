package com.example.pd.domain.mapper

import com.example.pd.data.source.remote.model.LoginRequest
import com.example.pd.data.source.remote.model.RegistrationRequest
import com.example.pd.domain.model.AuthorizationDtoModel
import com.example.pd.domain.model.RegistrationDtoModel
import com.example.pd.ui.model.AuthorizationUiModel
import com.example.pd.ui.model.RegistrationUiModel

interface AuthorizationDtoMapper {
    fun mapAuthorizationUiModelToDto(authorizationUiModel: AuthorizationUiModel): AuthorizationDtoModel
    fun mapAuthorizationDtoModelToRequest(authorizationDtoModel: AuthorizationDtoModel): LoginRequest
    fun mapRegistrationDtoModelToRequest(registrationDtoModel: RegistrationDtoModel): RegistrationRequest
    fun mapRegistrationUiModelToDto(registrationUiModel: RegistrationUiModel): RegistrationDtoModel
}