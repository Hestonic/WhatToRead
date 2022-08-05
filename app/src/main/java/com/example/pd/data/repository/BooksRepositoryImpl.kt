package com.example.pd.data.repository

import com.example.pd.data.mapper.BooksDtoMapperImpl
import com.example.pd.data.source.RemoteDataSource
import com.example.pd.domain.model.BookDtoModel
import com.example.pd.domain.repository.BooksRepository

class BooksRepositoryImpl(private val remoteDataSource: RemoteDataSource) : BooksRepository {
    
    override suspend fun getBooks(): List<BookDtoModel>? {
        val response = remoteDataSource.getBooks()
        if (response.isSuccessful) {
            response.body()?.let { booksResponse ->
                return BooksDtoMapperImpl.mapBooksResponseToBooksDtoModel(booksResponse)
            }
        }
        return null
    }
    
    override suspend fun getBook(id: String): BookDtoModel? {
        val response = remoteDataSource.getBook(id)
        if (response.isSuccessful) {
            response.body()?.let { bookResponse ->
                return BooksDtoMapperImpl.mapBookResponseToBookDtoModel(bookResponse)
            }
        }
        return null
    }
}