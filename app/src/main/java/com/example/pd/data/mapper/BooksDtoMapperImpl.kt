package com.example.pd.data.mapper

import com.example.pd.data.source.remote.model.BookResponse
import com.example.pd.data.source.remote.model.BooksResponse
import com.example.pd.domain.mapper.BooksDtoMapper
import com.example.pd.domain.model.BookDtoModel

object BooksDtoMapperImpl : BooksDtoMapper {
    override fun mapBooksResponseToBooksDtoModel(booksResponse: BooksResponse): List<BookDtoModel> =
        booksResponse.books.map {
            BookDtoModel(
                id = it.id,
                title = it.title,
                description = it.description,
                author = it.author,
                genres = it.genres
            )
        }
    
    override fun mapBookResponseToBookDtoModel(bookResponse: BookResponse): BookDtoModel =
        with(bookResponse) {
            BookDtoModel(
                id = book.id,
                title = book.title,
                description = book.description,
                author = book.author,
                genres = book.genres,
            )
        }
}