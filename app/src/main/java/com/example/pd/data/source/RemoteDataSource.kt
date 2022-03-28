package com.example.pd.data.source

import com.example.pd.data.api.WtrApi
import com.example.pd.data.api.WtrResponse

class RemoteDataSource(private val wtrApi: WtrApi) {
    suspend fun getWtr(): WtrResponse {
        return wtrApi.getWtr()
    }
}