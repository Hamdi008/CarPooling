package com.hamdi.carpooling.features.auth.signin.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String)

data class LoginResponse(
    @SerializedName("token")
    val token: String
)

data class ProfileResponse(
    @SerializedName("username")
    val username: String,

    @SerializedName("email")
    val email: String
)
