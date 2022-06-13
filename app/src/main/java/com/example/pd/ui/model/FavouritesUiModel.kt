package com.example.pd.ui.model

data class FavouritesUiModel(
    val tittle: String,
    val author: String,
    val rating: Float,
    val reviews: Int,
    val isFavourite: Boolean,
    val isRead: Boolean
)

object FavouritesDataHolder {
    private val favourite1 = FavouritesUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val favourite2 = FavouritesUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val favourite3 = FavouritesUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val favourite4 = FavouritesUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val favourite5 = FavouritesUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val favourite6 = FavouritesUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val favourite7 = FavouritesUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    private val favourite8 = FavouritesUiModel(
        tittle = "Билли Саммерс",
        author = "Стивен Кинг",
        rating = 4.04f,
        reviews = 183,
        isFavourite = false,
        isRead = false,
    )

    val favouriteList = listOf(
        favourite1,
        favourite2,
        favourite3,
        favourite4,
        favourite5,
        favourite6,
        favourite7,
        favourite8,
    )
}