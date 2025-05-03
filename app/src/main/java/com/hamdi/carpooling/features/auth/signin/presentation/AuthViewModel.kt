package com.hamdi.carpooling.features.auth.signin.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamdi.carpooling.features.auth.signin.data.model.LoginRequest
import com.hamdi.carpooling.features.auth.signin.domain.AuthRepository
import com.hamdi.carpooling.features.auth.signup.data.model.RegisterRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ){
        viewModelScope.launch {
            try {
                val response = authRepository.login(
                 request = LoginRequest(email = email, password = password)
                )
                if (response.isSuccessful) {
                    val getProfileResponse = authRepository.getProfile()
                    if (getProfileResponse.isSuccessful) {
                        Log.d("HEL:","Login Success")
                        onSuccess()
                    } else {
                        Log.d("HEL:","Login Failed}")
                        onError(getProfileResponse.message())
                    }
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                    Log.e("HEL:", "Login Failed: $errorMessage")
                    onError(errorMessage)
                }
            } catch (e: Exception) {
                Log.e("HEL:", "Exception: ${e.message}")
                onError(e.message ?: "Unexpected error")
            }
        }
    }
}