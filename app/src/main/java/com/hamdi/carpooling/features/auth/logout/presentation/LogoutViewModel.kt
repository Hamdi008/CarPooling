package com.hamdi.carpooling.features.auth.logout.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamdi.carpooling.features.auth.logout.domain.LogoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogoutViewModel @Inject constructor(
    private val logoutRepository: LogoutRepository
) : ViewModel() {

    fun logoutUser(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = logoutRepository.logoutUser()
                if (response.isSuccessful)
                    onSuccess()
                else
                    onError(response.message())
            } catch (e: Exception) {
                onError(e.message.toString())
            }
        }
    }
}