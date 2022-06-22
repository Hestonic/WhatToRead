package com.example.pd.ui.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pd.domain.repository.BooksRepository
import com.example.pd.ui.main.FilterInstance
import com.example.pd.ui.mapper.SearchUiMapper
import com.example.pd.ui.model.SearchUiModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val booksRepository: BooksRepository) : ViewModel() {
    
    private val _searchUiModeLiveData: MutableLiveData<List<SearchUiModel>> = MutableLiveData()
    val searchUiModelLiveData: LiveData<List<SearchUiModel>> get() = _searchUiModeLiveData
    
    private val getBooksFailedChannel = Channel<String>()
    val getBooksFailedFlow get() = getBooksFailedChannel.receiveAsFlow()
    
    fun getBooks() {
        viewModelScope.launch {
            try {
                booksRepository.getBooks()?.let { booksDtoModel ->
                    val searchUiModelList =
                        SearchUiMapper.mapBooksDtoModelToSearchUiModel(booksDtoModel)
                    _searchUiModeLiveData.postValue(searchUiModelList)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                getBooksFailedChannel.send("Ошибка соединения с сервером")
            }
        }
    }
    
    fun getFilteredBooks() {
        viewModelScope.launch {
            booksRepository.getBooks()?.let { booksDtoModel ->
                val searchUiModelList =
                    SearchUiMapper.mapBooksDtoModelToSearchUiModel(booksDtoModel)
                val filteredSearch: MutableList<SearchUiModel> = mutableListOf()
                if (FilterInstance.authors.isNotEmpty() && FilterInstance.genres.isNotEmpty()) {
                    searchUiModelList.forEach { searchUiModel ->
                        val currentGenres = searchUiModel.genres.split(", ")
                        currentGenres.forEach { currentGenre ->
                            FilterInstance.genres.forEach { genre ->
                                FilterInstance.authors.forEach { author ->
                                    if (searchUiModel.author == author && currentGenre == genre) {
                                        filteredSearch.add(searchUiModel)
                                    }
                                }
                            }
                        }
                    }
                    _searchUiModeLiveData.postValue(filteredSearch.distinct())
                } else {
                    if (FilterInstance.authors.isNotEmpty()) {
                        searchUiModelList.forEach { searchUiModel ->
                            FilterInstance.authors.forEach { author ->
                                if (searchUiModel.author == author)
                                    filteredSearch.add(searchUiModel)
                            }
                        }
                    } else if (FilterInstance.genres.isNotEmpty()) {
                        searchUiModelList.forEach { searchUiModel ->
                            val currentGenres = searchUiModel.genres.split(", ")
                            currentGenres.forEach { currentGenre ->
                                FilterInstance.genres.forEach { genre ->
                                    if (currentGenre == genre)
                                        filteredSearch.add(searchUiModel)
                                }
                            }
                        }
                    }
                    _searchUiModeLiveData.postValue(filteredSearch.distinct())
                }
                
                
            }
            
            
        }
    }
}