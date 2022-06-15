package com.example.pd.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    val userInfo: UserInfo,
    val success: Boolean,
)

data class UserInfo(
    val id: Int,
    val username: String,
    val email: String,
    val first_name: String,
    val last_name: String,
    val email_verified_at: String,
    val created_at: String,
    val updated_at: String,
)

