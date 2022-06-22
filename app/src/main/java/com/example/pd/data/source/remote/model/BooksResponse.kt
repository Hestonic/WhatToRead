package com.example.pd.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class BooksResponse(
    val success: Boolean,

    @SerializedName("data")
    val books: List<SingleBook>
)


