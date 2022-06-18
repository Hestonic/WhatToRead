package com.example.pd.ui.mapper

import com.example.pd.ui.model.RegistrationUiModel

object RegistrationUiMapper {
    fun mapUiModel(name: String, email: String, password: String, passwordRepeat: String) =
        RegistrationUiModel(name, email, password, passwordRepeat)
}