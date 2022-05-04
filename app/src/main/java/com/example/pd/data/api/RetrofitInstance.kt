package com.example.pd.data.api

import com.example.pd.data.source.LocalDataSource
import com.example.pd.data.source.RemoteDataSource
import com.example.pd.domain.repository.Repository
import com.example.pd.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val api: WtrApi by lazy {
        retrofit.create(WtrApi::class.java)
    }

    private val remoteDataSource = RemoteDataSource(api)
}