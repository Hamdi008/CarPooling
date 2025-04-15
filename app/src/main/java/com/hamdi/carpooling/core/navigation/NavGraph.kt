package com.hamdi.carpooling.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hamdi.carpooling.features.home.ui.HomeScreen

@Composable
fun AppNavigation(modifier: Modifier) {
    NavHost(
        navController = LocalNavController.current,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(modifier = modifier)
        }
    }
}
