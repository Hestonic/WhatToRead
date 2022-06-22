package com.example.pd.ui.model

data class FilterUiModel(
    val title: String,
    var isVisible: Boolean,
    val filterItems: List<FilterItem>
)

data class FilterItem(
    val id: String,
    val name: String
)