package com.example.pd.domain.model

data class RegistrationDtoModel(
    val first_name: String,
    val email: String,
    val password: String,
    val password_confirmation: String,
)
