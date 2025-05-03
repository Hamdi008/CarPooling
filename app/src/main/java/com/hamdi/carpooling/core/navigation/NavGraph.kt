package com.hamdi.carpooling.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hamdi.carpooling.core.navigation.Routes.HOME
import com.hamdi.carpooling.core.navigation.Routes.SIGN_IN
import com.hamdi.carpooling.core.navigation.Routes.SIGN_UP
import com.hamdi.carpooling.features.auth.signin.ui.SignInScreen
import com.hamdi.carpooling.features.auth.signup.ui.SignUpScreen
import com.hamdi.carpooling.features.welcome.ui.WelcomeScreen

@Composable
fun AppNavigation(modifier: Modifier) {
    NavHost(
        navController = LocalNavController.current,
        startDestination = HOME
    ) {
        composable(HOME) {
            WelcomeScreen(modifier = modifier)
        }
        composable(SIGN_UP) {
            SignUpScreen()
        }
        composable(SIGN_IN) {
            SignInScreen()
        }
    }
}

object Routes {
    const val HOME = "home"
    const val SIGN_UP = "sign_up"
    const val SIGN_IN = "sign_in"

}
