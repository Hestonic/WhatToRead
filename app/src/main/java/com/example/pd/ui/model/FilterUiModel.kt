package com.example.pd.ui.model

data class FilterBox(
    val isVisible: Boolean,
    val tittle: String,
    val filter: List<FilterUiModel>
)

data class FilterUiModel(
    val name: String,
    val isChecked: Boolean
)

object FilterObjectHolder {
    private val genres = FilterBox(
        isVisible = false,
        tittle = "Жанр",
        filter = listOf(
            FilterUiModel(
                name = "Комедия",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Ужасы",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Классика",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Зарубежная литература",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Детские книги",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Детективы",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Фантастика",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Приключения",
                isChecked = false,
            )
        )
    )

    private val authors = FilterBox(
        isVisible = true,
        tittle = "Автор",
        filter = listOf(
            FilterUiModel(
                name = "Стивен Кинг ",
                isChecked = false,
            ),
            FilterUiModel(
                name = "фёдор Достоевский",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Оскар Уайльд",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Анна Коренина",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Эрих Мария Ремарк",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Александр Блок",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Антуан де Сент-Экзюпери",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Джоан Роулинг",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Стивен Кинг ",
                isChecked = false,
            ),
            FilterUiModel(
                name = "фёдор Достоевский",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Оскар Уайльд",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Анна Коренина",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Эрих Мария Ремарк",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Александр Блок",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Антуан де Сент-Экзюпери",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Стивен Кинг ",
                isChecked = false,
            ),
            FilterUiModel(
                name = "фёдор Достоевский",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Оскар Уайльд",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Анна Коренина",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Эрих Мария Ремарк",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Александр Блок",
                isChecked = false,
            ),
            FilterUiModel(
                name = "Антуан де Сент-Экзюпери",
                isChecked = false,
            ),
        )
    )

    val filterBoxes = listOf(genres, authors)
}
