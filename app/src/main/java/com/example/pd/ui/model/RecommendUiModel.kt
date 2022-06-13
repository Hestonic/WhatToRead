package com.example.pd.ui.model

data class RecommendUiModel(
    val name: String,
    val author: String,
    val genres: String,
    val rating: Double,
    val reviews: Int,
    val description: String,
)

object RecommendHolderData {
    private val recommend1 = RecommendUiModel(
            "Билли Саммерс",
            "Стивен Кинг",
            "фантастика, ужасы и мистика",
            4.04,
            183,
            "Новый роман Стивена Кинга!" +
                    " Захватывающая история о хорошем парне, который выполняет плохую работу...\n"
        )

    private val recommend2 = RecommendUiModel(
        "Билли Саммерс",
        "Стивен Кинг",
        "фантастика, ужасы и мистика",
        4.04,
        183,
        "Новый роман Стивена Кинга!" +
                " Захватывающая история о хорошем парне, который выполняет плохую работу...\n"
    )

    private val recommend3 = RecommendUiModel(
        "Билли Саммерс",
        "Стивен Кинг",
        "фантастика, ужасы и мистика",
        4.04,
        183,
        "Новый роман Стивена Кинга!" +
                " Захватывающая история о хорошем парне, который выполняет плохую работу...\n"
    )

    private val recommend4 = RecommendUiModel(
        "Билли Саммерс",
        "Стивен Кинг",
        "фантастика, ужасы и мистика",
        4.04,
        183,
        "Новый роман Стивена Кинга!" +
                " Захватывающая история о хорошем парне, который выполняет плохую работу...\n"
    )

    private val recommend5 = RecommendUiModel(
        "Билли Саммерс",
        "Стивен Кинг",
        "фантастика, ужасы и мистика",
        4.04,
        183,
        "Новый роман Стивена Кинга!" +
                " Захватывающая история о хорошем парне, который выполняет плохую работу...\n"
    )

    val recommendList = listOf(
        recommend1,
        recommend2,
        recommend3,
        recommend4,
        recommend5,
    )
}
