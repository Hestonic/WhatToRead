package com.example.pd.ui.mapper

import com.example.pd.domain.model.BookDtoModel
import com.example.pd.ui.model.Comment
import com.example.pd.ui.model.DetailsUiModel
import com.example.pd.ui.model.ExpandableDescription

object DetailsUiMapper {
    fun mapBookDtoModelToUiModel(bookDtoModel: BookDtoModel): DetailsUiModel = with(bookDtoModel) {
        DetailsUiModel(
            id = id,
            title = title,
            author = author,
            genres = genres.toString().replace("[", "").replace("]", ""),
            selfRating = 4f,
            averageRating = "4",
            reviews = "23",
            ageLimit = "18+",
            expandableDescription = listOf(
                ExpandableDescription(
                    tittle = "Аннотация",
                    description = description,
                    visible = true,
                    comments = emptyList(),
                    commentsVisible = false,
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
                      "Частица: 25\n",
                    visible = false,
                    comments = emptyList(),
                    commentsVisible = false,
                ),
                ExpandableDescription(
                    tittle = "Отзывы",
                    description = description,
                    visible = false,
                    comments = listOf(
                        Comment(
                            name = "Алексей Дубков",
                            comment = "Это амбициозная книга, которая пытается объединить множество тем и историй. У нас есть отношения любви/ненависти Саи с ее наставником, ограбление, связанное с политической ситуацией, и предыстории почти каждого персонажа, включая нескольких второстепенных персонажей."
                        ),
                        Comment(
                            name = "Василиса Прекрасная",
                            comment = "С удовольствием прочла данную книгу. Здесь есть буквально всё: гламурная жизнь, литературные и исторические отсылки, любовь и ненависть. Думаю, что вряд ли вы сможете просто отложить её на полку, настолько увлекательно автор совмещает здесь разные линии сюжета. Точно могу порекомендовать тем, кто хочет прочитать что-то другое, чем просто заурядная проза."
                        ),
                        Comment(
                            name = "Андрей Некрасов",
                            comment = "С удовольствием прочла данную книгу. Здесь есть буквально всё: гламурная жизнь, литературные и исторические отсылки, любовь и ненависть. Думаю, что вряд ли вы сможете просто отложить её на полку, настолько увлекательно автор совмещает здесь разные линии сюжета. Точно могу порекомендовать тем, кто хочет прочитать что-то другое, чем просто заурядная проза."
                        ),
                        Comment(
                            name = "Денис Абрамов",
                            comment = "С удовольствием прочла данную книгу. Здесь есть буквально всё: гламурная жизнь, литературные и исторические отсылки, любовь и ненависть. Думаю, что вряд ли вы сможете просто отложить её на полку, настолько увлекательно автор совмещает здесь разные линии сюжета. Точно могу порекомендовать тем, кто хочет прочитать что-то другое, чем просто заурядная проза."
                        ),
                    ),
                    commentsVisible = true,
                ),
            )
        )
    }
}