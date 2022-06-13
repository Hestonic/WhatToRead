package com.example.pd.ui.mapper

import com.example.pd.ui.model.AuthorizationUiModel

object AuthorizationUiMapper {
    fun mapLoginUiModel(login: String, password: String) = AuthorizationUiModel(login, password)
}