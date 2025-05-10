package com.hamdi.carpooling.features.auth.pin.data

import com.hamdi.carpooling.features.auth.pin.data.remote.PinApi
import com.hamdi.carpooling.features.auth.pin.domain.PinRepository
import javax.inject.Inject

class PinRepositoryImpl @Inject constructor(
    private val pinApi: PinApi
): PinRepository {
}