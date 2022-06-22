package com.example.pd.ui.model

data class DetailsUiModel(
    val id: Int,
    val title: String,
    val author: String,
    val genres: String,
    val selfRating: Float,
    val averageRating: String,
    val reviews: String,
    val ageLimit: String,
    val expandableDescription: List<ExpandableDescription>,
)

data class ExpandableDescription(
    val tittle: String,
    val description: String,
    var visible: Boolean,
    val comments: List<Comment>,
    var commentsVisible: Boolean,
)

data class Comment(
    val name: String,
    val comment: String,
)