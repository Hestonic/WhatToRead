package com.example.pd.domain.model

data class BookDtoModel(
    val id: Int,
    val title: String,
    val description: String,
    val author: String,
    val genres: List<String>,
)
