package com.example.pd.ui.model

data class SearchUiModel(
    val id: Int,
    val title: String,
    val author: String,
    val genres: String,
    val rating: Double,
    val reviews: Int,
    val description: String,
)
/*
//TODO: не забыть удалить
object SearchHolderData {
    private val search1 = SearchUiModel(
        "Билли Саммерс",
        "Стивен Кинг",
        "фантастика, ужасы и мистика",
        4.04,
        183,
        "Новый роман Стивена Кинга!" +
                " Захватывающая история о хорошем парне, который выполняет плохую работу...\n"
    )

    private val search2 = SearchUiModel(
        "Билли Саммерс",
        "Стивен Кинг",
        "фантастика, ужасы и мистика",
        4.04,
        183,
        "Новый роман Стивена Кинга!" +
                " Захватывающая история о хорошем парне, который выполняет плохую работу...\n"
    )

    private val search3 = SearchUiModel(
        "Билли Саммерс",
        "Стивен Кинг",
        "фантастика, ужасы и мистика",
        4.04,
        183,
        "Новый роман Стивена Кинга!" +
                " Захватывающая история о хорошем парне, который выполняет плохую работу...\n"
    )

    private val search4 = SearchUiModel(
        "Билли Саммерс",
        "Стивен Кинг",
        "фантастика, ужасы и мистика",
        4.04,
        183,
        "Новый роман Стивена Кинга!" +
                " Захватывающая история о хорошем парне, который выполняет плохую работу...\n"
    )

    private val search5 = SearchUiModel(
        "Билли Саммерс",
        "Стивен Кинг",
        "фантастика, ужасы и мистика",
        4.04,
        183,
        "Новый роман Стивена Кинга!" +
                " Захватывающая история о хорошем парне, который выполняет плохую работу...\n"
    )

    val searchList = listOf(
        search1,
        search2,
        search3,
        search4,
        search5,
    )
}*/
