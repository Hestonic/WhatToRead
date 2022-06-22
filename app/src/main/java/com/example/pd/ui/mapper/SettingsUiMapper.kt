package com.example.pd.ui.mapper

import com.example.pd.domain.model.UserDtoModel
import com.example.pd.ui.model.SettingsUiModel

object SettingsUiMapper {
    
    fun mapUserDtoModelToSettingsUiModel(userDtoModel: UserDtoModel): SettingsUiModel =
        with(userDtoModel) {
            SettingsUiModel(
                firstName = first_name,
                lastName = last_name ?: "",
                email = email,
            )
        }
    
    
}