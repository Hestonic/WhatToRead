package com.example.pd.domain.repository

import android.util.Log
import com.example.pd.data.source.LocalDataSource
import com.example.pd.data.source.RemoteDataSource
import com.example.pd.domain.mapper.DtoMapper
import com.example.pd.domain.model.DtoModel
import java.lang.Exception

class Repository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getWtr(): DtoModel? {
        return try {
            val response = remoteDataSource.getWtr()
            DtoMapper.map(response)
        } catch (e: Exception) {
            Log.d("MY_TAG_EXCEPTION", e.toString())
            null
        }
    }

}