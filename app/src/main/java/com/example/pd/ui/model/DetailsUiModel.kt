package com.example.pd.ui.model

data class DetailsUiModel(
    val posterName: String,
    val author: String,
    val genres: String,
    val selfRating: Float,
    val averageRating: String,
    val reviews: String,
    val ageLimit: String,
    val annotation: String,
    val expandableDescription: List<ExpandableDescription>,
)

data class ExpandableDescription(
    val tittle: String,
    val description: String,
)

object DetailsHolder {
    val billySummers = DetailsUiModel(
        posterName = "",
        author = "",
        genres = "",
        selfRating = 0f,
        averageRating = "",
        reviews = "",
        ageLimit = "",
        annotation = "",
        expandableDescription = listOf(
            ExpandableDescription(
                tittle = "Морфологический разбор",
                description = "Существительное: 10\n" +
                        "Прилагательное: 15\n" +
                        "Глагол: 20\n" +
                        "Наречие: 10\n" +
                        "Местоимение: 10\n" +
                        "Предлог: 15\n" +
                        "Союз: 20\n" +
                        "Частица: 25",
            ),
            ExpandableDescription(
                tittle = "Отзывы",
                description = "",
            ),
        )
    )
}
