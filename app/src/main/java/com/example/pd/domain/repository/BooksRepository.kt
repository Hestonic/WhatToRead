package com.example.pd.domain.repository

import com.example.pd.domain.model.BookDtoModel

interface BooksRepository {
    suspend fun getBooks(): List<BookDtoModel>?
    suspend fun getBook(id: String): BookDtoModel?
}