package com.example.pd.ui.model

data class ReadUiModel(
    val tittle: String,
    val author: String,
    val rating: Float,
    val reviews: Int,
    val isFavourite: Boolean,
    val isRead: Boolean
)

object ReadDataHolder {
    private val read1 = ReadUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val read2 = ReadUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    val readList = listOf(read1, read2)
}