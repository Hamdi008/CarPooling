package com.hamdi.carpooling.features.home.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamdi.carpooling.features.home.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    var homeMessage = mutableStateOf("Loading...")
        private set

    init {
        viewModelScope.launch {
            Log.d("HEL:", "HomeViewModel init")

            homeMessage.value = homeRepository.getHomeData()
        }
    }
}