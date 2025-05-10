package com.hamdi.carpooling.features.auth.pin.data.remote

import com.hamdi.carpooling.features.auth.pin.data.model.SendPinRequest
import com.hamdi.carpooling.features.auth.pin.data.model.SendPinResponse
import com.hamdi.carpooling.features.auth.pin.data.model.VerifyPinRequest
import com.hamdi.carpooling.features.auth.pin.data.model.VerifyPinResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PinApi {

    @POST("api/send-pin")
    suspend fun sendPin(@Body request: SendPinRequest): Response<SendPinResponse>

    @POST("api/verify-pin")
    suspend fun verifyPin(@Body request: VerifyPinRequest): Response<VerifyPinResponse>
}