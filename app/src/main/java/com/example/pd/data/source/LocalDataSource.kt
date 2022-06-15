package com.example.pd.data.source

import com.example.pd.data.mapper.UserDtoMapperImpl
import com.example.pd.data.source.local.dao.UserDao
import com.example.pd.data.source.local.entity.UserEntity
import com.example.pd.domain.model.UserDtoModel

class LocalDataSource(private val userDao: UserDao) {
    
    suspend fun addUserDatabase(userDtoModel: UserDtoModel) {
        val userEntity = UserDtoMapperImpl.mapUserDtoModelToEntity(userDtoModel)
        userDao.addUserDatabase(userEntity)
    }
    
    fun searchUserByEmail(email: String): UserEntity {
        return userDao.searchUserByEmail(email)
    }
    
    fun selectAllUsers(): List<UserEntity> {
        return userDao.selectAllUsers()
    }
    
}