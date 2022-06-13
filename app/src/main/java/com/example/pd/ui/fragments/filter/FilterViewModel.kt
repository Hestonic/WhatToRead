package com.example.pd.ui.fragments.filter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pd.ui.model.FilterBox

class FilterViewModel : ViewModel() {

    private val _filterLiveData: MutableLiveData<List<FilterBox>> = MutableLiveData()
    val filterLiveData: LiveData<List<FilterBox>> get() = _filterLiveData

    

}