package com.example.pd.data.mapper

import com.example.pd.data.source.local.entity.UserEntity
import com.example.pd.data.source.remote.model.UserResponse
import com.example.pd.domain.mapper.UserDtoMapper
import com.example.pd.domain.model.UserDtoModel

object UserDtoMapperImpl : UserDtoMapper {
    override fun mapUserResponseToDtoModel(userResponse: UserResponse) = with(userResponse) {
        UserDtoModel(
            id = userInfo.id,
            email = userInfo.email,
            first_name = userInfo.first_name,
        )
    }
    
    override fun mapUserDtoModelToEntity(userDtoModel: UserDtoModel): UserEntity {
        return UserEntity(
            id = userDtoModel.id,
            email = userDtoModel.email,
            first_name = userDtoModel.first_name
        )
    }
    
}