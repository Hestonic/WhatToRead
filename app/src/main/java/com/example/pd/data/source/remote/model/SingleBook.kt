package com.example.pd.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class SingleBook(
    val id: Int,
    val title: String,
    val description: String,
    val author: String,
    val genres: List<String>,
    
    @SerializedName("created_at")
    val createdAt: String,
    
    @SerializedName("updated_at")
    val updatedAt: String,
)
