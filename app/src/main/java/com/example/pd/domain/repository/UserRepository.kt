package com.example.pd.domain.repository

import com.example.pd.domain.model.UserDtoModel

interface UserRepository {
    suspend fun getUser(token: String): UserDtoModel?
}