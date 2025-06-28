package com.hamdi.carpooling.features.auth.pin.data

import com.hamdi.carpooling.features.auth.pin.data.model.SendPinRequest
import com.hamdi.carpooling.features.auth.pin.data.model.SendPinResponse
import com.hamdi.carpooling.features.auth.pin.data.model.VerifyPinRequest
import com.hamdi.carpooling.features.auth.pin.data.model.VerifyPinResponse
import com.hamdi.carpooling.features.auth.pin.data.remote.PinApi
import com.hamdi.carpooling.features.auth.pin.domain.PinRepository
import retrofit2.Response
import javax.inject.Inject

class PinRepositoryImpl @Inject constructor(
    private val pinApi: PinApi
): PinRepository {

    override suspend fun sendPin(request: SendPinRequest): Response<SendPinResponse> {
        return pinApi.sendPin(request)
    }

    override suspend fun verifyPin(request: VerifyPinRequest): Response<VerifyPinResponse> {
        return pinApi.verifyPin(request)
    }

}