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

    val favouriteList = listOf(favourite1, favourite2)
}