package com.hamdi.carpooling.features.auth.pin.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamdi.carpooling.features.auth.pin.data.model.SendPinRequest
import com.hamdi.carpooling.features.auth.pin.data.model.SendPinResponse
import com.hamdi.carpooling.features.auth.pin.data.model.VerifyPinRequest
import com.hamdi.carpooling.features.auth.pin.data.model.VerifyPinResponse
import com.hamdi.carpooling.features.auth.pin.domain.PinRepository
import com.hamdi.carpooling.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PinViewModel @Inject constructor(
    private val pinRepository: PinRepository
) : ViewModel() {

    private val _sendPinState = mutableStateOf<ResultState<SendPinResponse>>(ResultState.Idle)
    val sendPinState: State<ResultState<SendPinResponse>> get() = _sendPinState

    private val _verifyPinState = mutableStateOf<ResultState<VerifyPinResponse>>(ResultState.Idle)
    val verifyPinState: State<ResultState<VerifyPinResponse>> get() = _verifyPinState


    fun sendPin(phoneNumber: String) {
        viewModelScope.launch {
            _sendPinState.value = ResultState.Loading
            try {
                val response = pinRepository.sendPin(SendPinRequest(phoneNumber))
                _sendPinState.value = handleResponse(response)
            } catch (e: Exception) {
                _sendPinState.value = ResultState.Error(e.localizedMessage ?: "Unknown Error")
            }
        }
    }

    fun verifyPin(phoneNumber: String, pin: String) {
        viewModelScope.launch {
            _verifyPinState.value = ResultState.Loading
            try {
                val response = pinRepository.verifyPin(VerifyPinRequest(phoneNumber, pin))
                _verifyPinState.value = handleResponse(response)
            } catch (e: Exception) {
                _verifyPinState.value = ResultState.Error(e.localizedMessage ?: "Unknown Error")
            }
        }
    }

    private fun <T> handleResponse(response: Response<T>): ResultState<T> {
        return if (response.isSuccessful && response.body() != null) {
            ResultState.Success(response.body()!!)
        } else {
            ResultState.Error(response.message())
        }
    }
}