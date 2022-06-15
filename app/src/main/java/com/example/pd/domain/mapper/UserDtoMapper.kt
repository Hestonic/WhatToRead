package com.example.pd.domain.mapper

import com.example.pd.data.source.local.entity.UserEntity
import com.example.pd.data.source.remote.model.UserResponse
import com.example.pd.domain.model.UserDtoModel

interface UserDtoMapper {
    fun mapUserResponseToDtoModel(userResponse: UserResponse): UserDtoModel
    fun mapUserDtoModelToEntity(userDtoModel: UserDtoModel): UserEntity
}