package com.example.pd.data.repository

import android.util.Log
import com.example.pd.data.mapper.UserDtoMapperImpl
import com.example.pd.data.source.LocalDataSource
import com.example.pd.data.source.RemoteDataSource
import com.example.pd.domain.model.UserDtoModel
import com.example.pd.domain.repository.UserRepository

class UserRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : UserRepository {
    override suspend fun getUser(token: String): UserDtoModel? {
        val response = remoteDataSource.getUser(token)
        if (response.isSuccessful)
            response.body()
                ?.let { user -> return UserDtoMapperImpl.mapUserResponseToDtoModel(user) }
        else {
            Log.d("userRep_getUser", response.errorBody().toString())
            return null
        }
        return null
    }
    
    
}