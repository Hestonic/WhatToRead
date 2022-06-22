package com.example.pd

import android.app.Application

class App : Application() {
    
    val dependencyInjection = DependencyInjection()
    
    override fun onCreate() {
        super.onCreate()
        dependencyInjection.initDao(this)
        dependencyInjection.initDataSources(dependencyInjection.userDao)
        dependencyInjection.initRepositories(
            dependencyInjection.localDataSource,
            dependencyInjection.remoteDataSource
        )
    }
    
}