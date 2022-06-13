package com.example.pd.data.api.model

data class LoginRequest(
    val email: String,
    val password: String,
    val remember: Boolean
)
