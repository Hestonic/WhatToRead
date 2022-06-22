package com.example.pd.data.mapper

import com.example.pd.data.source.remote.model.LoginRequest
import com.example.pd.data.source.remote.model.RegistrationRequest
import com.example.pd.domain.mapper.AuthorizationDtoMapper
import com.example.pd.domain.model.AuthorizationDtoModel
import com.example.pd.domain.model.RegistrationDtoModel
import com.example.pd.ui.model.AuthorizationUiModel
import com.example.pd.ui.model.RegistrationUiModel

object AuthorizationDtoMapperImpl : AuthorizationDtoMapper {
    
    override fun mapAuthorizationUiModelToDto(authorizationUiModel: AuthorizationUiModel) =
        with(authorizationUiModel) {
            AuthorizationDtoModel(login, password)
        }
    
    override fun mapAuthorizationDtoModelToRequest(authorizationDtoModel: AuthorizationDtoModel) =
        with(authorizationDtoModel) {
            LoginRequest(login, password, true)
        }
    
    override fun mapRegistrationDtoModelToRequest(registrationDtoModel: RegistrationDtoModel): RegistrationRequest =
        with(registrationDtoModel) {
            RegistrationRequest(first_name, email, password, password_confirmation)
        }
    
    override fun mapRegistrationUiModelToDto(registrationUiModel: RegistrationUiModel): RegistrationDtoModel =
        with(registrationUiModel) {
            RegistrationDtoModel(first_name, email, password, password_confirmation)
        }
    
}