package com.hamdi.carpooling.core.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import com.hamdi.carpooling.core.presentation.MainViewModel

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("NavController not provided")
}

val LocalSnackbarHostState = staticCompositionLocalOf<SnackbarHostState> {
    error("SnackbarHostState not provided")
}

val LocalMainViewModel = staticCompositionLocalOf<MainViewModel> {
    error("MainViewModel not provided")
}
