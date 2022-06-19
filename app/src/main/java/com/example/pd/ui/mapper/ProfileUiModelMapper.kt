package com.example.pd.ui.mapper

import com.example.pd.domain.model.UserDtoModel
import com.example.pd.ui.model.ProfileUiModel

object ProfileUiModelMapper {
    fun mapUiModel(userDtoModel: UserDtoModel): ProfileUiModel = with(userDtoModel) {
        val lastName = last_name ?: ""
        ProfileUiModel(name = "$first_name $lastName")
    }
}
