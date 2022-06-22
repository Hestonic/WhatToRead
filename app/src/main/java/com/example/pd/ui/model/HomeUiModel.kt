package com.example.pd.ui.model

data class HomeUiModel(
    val tittle: String
)

object HomeHolderData {
    private val tittle1 = HomeUiModel("Вам понравится")
    private val tittle2 = HomeUiModel("Многим нравится")
    private val tittle3 = HomeUiModel("Это классика")
    private val tittle4 = HomeUiModel("Популярная фантастика")
    private val tittle5 = HomeUiModel("Самый лучший научный научпоп")
    private val tittle6 = HomeUiModel("Лучшие из детективов")
    private val tittle7 = HomeUiModel("Приключения века")
    private val tittle8 = HomeUiModel("Топ романов всех времен и народов")
    private val tittle9 = HomeUiModel("Что то ещё")
    private val tittle10 = HomeUiModel("И ещё что то для текста")

    val detailsList = listOf(
        tittle1,
        tittle2,
        tittle3,
        tittle4,
        tittle5,
        tittle6,
        tittle7,
        tittle8,
        tittle9,
        tittle10,
    )
}
