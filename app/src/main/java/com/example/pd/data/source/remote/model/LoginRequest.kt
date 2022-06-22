package com.example.pd.data.source.remote.model

data class LoginRequest(
    val email: String,
    val password: String,
    val remember: Boolean
)
