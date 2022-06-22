package com.example.pd.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class BookResponse(
    val success: Boolean,
    
    @SerializedName("data")
    val book: SingleBook
)
