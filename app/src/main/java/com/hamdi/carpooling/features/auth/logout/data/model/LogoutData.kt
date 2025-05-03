package com.hamdi.carpooling.features.auth.logout.data.model

import com.google.gson.annotations.SerializedName

data class LogoutResponse(
    @SerializedName("message")
    val message: String
)
