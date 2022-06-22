package com.example.pd.ui.mapper

import com.example.pd.ui.model.AuthorizationUiModel

object AuthorizationUiMapper {
    fun mapUiModel(login: String, password: String) = AuthorizationUiModel(login, password)
}