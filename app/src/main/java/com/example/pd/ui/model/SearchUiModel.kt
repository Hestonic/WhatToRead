package com.example.pd.ui.model

data class SearchUiModel(
    val name: String,
    val author: String,
    val genres: String,
    val rating: Double,
    val reviews: Int,
    val description: String,
)