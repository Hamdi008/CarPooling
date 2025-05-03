package com.hamdi.carpooling.features.welcome.data.model

import com.google.gson.annotations.SerializedName

data class WelcomeResponse(
    @SerializedName("message")
    val welcomeMessage: String
)