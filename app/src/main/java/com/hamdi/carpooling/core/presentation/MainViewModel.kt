package com.hamdi.carpooling.core.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

    private val _snackbarMessage = mutableStateOf<String?>(null)
    val snackbarMessage: State<String?> get() = _snackbarMessage

    fun showSnackbar(message: String) {
        Log.d("HEL:","MainViewModel set snackbarMessage to $message")
        _snackbarMessage.value = message
    }

    fun clearSnackbarMessage() {
        Log.d("HEL:","MainViewModel clear snackbarMessage")
        _snackbarMessage.value = null
    }
}