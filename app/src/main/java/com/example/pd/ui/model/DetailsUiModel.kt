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
    var visible: Boolean = false
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
                tittle = "Аннотация",
                description = "Новый роман Стивена Кинга!" +
                        "Захватывающая история о хорошем парне, который выполняет плохую работу." +
                        "Стивен Кинг — один из самых популярных авторов современности. Он написал " +
                        "свыше шести десятков бестселлеров, которые переведены на 44 языка, изданы " +
                        "в 80 странах мира и разошлись тиражом свыше 400 000 000 экземпляров." +
                        "«Лучшая книга Стивена Кинга за долгие годы» по версии газеты The Guardian.",
                visible = true,
                ),
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
                visible = false,
            ),
            ExpandableDescription(
                tittle = "Отзывы",
                description = "",
                visible = false,
            ),
        )
    )
}
