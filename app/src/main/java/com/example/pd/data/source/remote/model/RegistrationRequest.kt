package com.example.pd.data.source.remote.model

data class RegistrationRequest(
    val first_name: String,
    val email: String,
    val password: String,
    val password_confirmation: String,
)