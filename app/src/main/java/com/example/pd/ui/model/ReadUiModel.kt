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

    private val read3 = ReadUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val read4 = ReadUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val read5 = ReadUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val read6 = ReadUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val read7 = ReadUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val read8 = ReadUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val read9 = ReadUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val read10 = ReadUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    val readList = listOf(
        read1,
        read2,
        read3,
        read4,
        read5,
        read6,
        read7,
        read8,
        read9,
        read10,
    )
}