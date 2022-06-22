package com.example.pd.domain.repository

import com.example.pd.ui.model.AuthorizationUiModel
import com.example.pd.ui.model.RegistrationUiModel

interface AuthorizationRepository {
    suspend fun login(authorizationUiModel: AuthorizationUiModel): String?
    suspend fun registration(registrationUiModel: RegistrationUiModel): String?
}