package com.hamdi.carpooling.features.auth.pin.domain

import com.hamdi.carpooling.features.auth.pin.data.model.SendPinRequest
import com.hamdi.carpooling.features.auth.pin.data.model.SendPinResponse
import com.hamdi.carpooling.features.auth.pin.data.model.VerifyPinRequest
import com.hamdi.carpooling.features.auth.pin.data.model.VerifyPinResponse
import retrofit2.Response


interface PinRepository {

    suspend fun sendPin(request: SendPinRequest): Response<SendPinResponse>

    suspend fun verifyPin(request: VerifyPinRequest): Response<VerifyPinResponse>
}