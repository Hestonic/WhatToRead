package com.example.pd.data.repository

import android.util.Log
import com.example.pd.data.mapper.UserDtoMapperImpl
import com.example.pd.data.source.LocalDataSource
import com.example.pd.data.source.RemoteDataSource
import com.example.pd.domain.repository.UserRepository

class UserRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : UserRepository {
    
    override suspend fun getUser(token: String): Boolean {
        Log.d("token", token)
        remoteDataSource.getUser(token).let { response ->
            if (response.isSuccessful)
                response.body()?.let { user ->
                    val userDtoModel = UserDtoMapperImpl.mapUserResponseToDtoModel(user)
                    localDataSource.addUserDatabase(userDtoModel)
                    return true
                }
            return false
        }
    }
    
}