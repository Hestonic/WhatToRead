package com.example.pd.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val email: String,
    val first_name: String,
)
