package com.hamdi.carpooling.features.home.data.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("message")
    val homeMessage: String
)