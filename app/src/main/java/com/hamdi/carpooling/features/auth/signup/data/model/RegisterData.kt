package com.hamdi.carpooling.features.auth.signup.data.model

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("username")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String // plain text password
)

data class RegisterResponse(
    @SerializedName("message")
    val message: String
)

