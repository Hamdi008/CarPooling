package com.hamdi.carpooling.features.auth.pin.data.model

import com.google.gson.annotations.SerializedName

data class SendPinRequest(
    @SerializedName("phoneNumber")
    val phoneNumber: String
)

data class SendPinResponse(
    @SerializedName("message")
    val message: String
)

data class VerifyPinRequest(
    @SerializedName("phoneNumber")
    val phoneNumber: String,

    @SerializedName("pin")
    val pin: String
)

data class VerifyPinResponse(
    @SerializedName("message")
    val message: String
)