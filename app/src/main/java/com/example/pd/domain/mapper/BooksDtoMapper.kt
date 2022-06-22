package com.example.pd.domain.mapper

import com.example.pd.data.source.remote.model.BookResponse
import com.example.pd.data.source.remote.model.BooksResponse
import com.example.pd.domain.model.BookDtoModel

interface BooksDtoMapper {
    fun mapBooksResponseToBooksDtoModel(booksResponse: BooksResponse): List<BookDtoModel>
    fun mapBookResponseToBookDtoModel(bookResponse: BookResponse): BookDtoModel
}