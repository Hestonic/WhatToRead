package com.example.pd

import android.content.Context
import com.example.pd.data.repository.*
import com.example.pd.data.source.LocalDataSource
import com.example.pd.data.source.RemoteDataSource
import com.example.pd.data.source.local.WhatToReadDatabase
import com.example.pd.data.source.local.dao.UserDao
import com.example.pd.data.source.remote.RetrofitInstance
import com.example.pd.domain.repository.*

class DependencyInjection {
    
    lateinit var userDao: UserDao
    lateinit var localDataSource: LocalDataSource
    lateinit var remoteDataSource: RemoteDataSource
    lateinit var authorizationRepository: AuthorizationRepository
    lateinit var userRepository: UserRepository
    lateinit var booksRepository: BooksRepository
    lateinit var filterRepository: FilterRepository
    lateinit var commentRepository: CommentRepository
    
    
    fun initDao(context: Context) {
        userDao = WhatToReadDatabase.getDatabase(context).userDao
    }
    
    fun initDataSources(userDao: UserDao) {
        localDataSource = LocalDataSource(userDao)
        remoteDataSource = RemoteDataSource(RetrofitInstance.api)
    }
    
    fun initRepositories(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource) {
        authorizationRepository = AuthorizationRepositoryImpl(remoteDataSource)
        userRepository = UserRepositoryImpl(localDataSource, remoteDataSource)
        booksRepository = BooksRepositoryImpl(remoteDataSource)
        filterRepository = FilterRepositoryImpl(remoteDataSource)
        commentRepository = CommentRepositoryImpl(remoteDataSource)
    }

}