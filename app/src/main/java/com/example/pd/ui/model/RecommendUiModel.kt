package com.example.pd.ui.model

data class RecommendUiModel(
    val id: Int,
    val title: String,
    val author: String,
    val genres: String,
    val rating: Double,
    val reviews: Int,
    val description: String,
)