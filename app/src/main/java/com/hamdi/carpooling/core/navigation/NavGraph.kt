package com.hamdi.carpooling.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hamdi.carpooling.core.navigation.Routes.CONTACT
import com.hamdi.carpooling.core.navigation.Routes.HOME
import com.hamdi.carpooling.core.navigation.Routes.PIN
import com.hamdi.carpooling.core.navigation.Routes.SIGN_IN
import com.hamdi.carpooling.core.navigation.Routes.SIGN_UP
import com.hamdi.carpooling.core.navigation.Routes.WELCOME
import com.hamdi.carpooling.features.auth.pin.ui.PinScreen
import com.hamdi.carpooling.features.auth.signin.ui.SignInScreen
import com.hamdi.carpooling.features.auth.signup.ui.SignUpScreen
import com.hamdi.carpooling.features.contact.ui.ContactScreen
import com.hamdi.carpooling.features.home.ui.HomeScreen
import com.hamdi.carpooling.features.welcome.ui.WelcomeScreen

@Composable
fun AppNavigation(modifier: Modifier) {
    NavHost(
        navController = LocalNavController.current,
        startDestination = WELCOME
    ) {
        composable(WELCOME) {
            WelcomeScreen(modifier = modifier)
        }
        composable(SIGN_UP) {
            SignUpScreen()
        }
        composable(SIGN_IN) {
            SignInScreen()
        }
        composable(HOME) {
            HomeScreen(modifier = modifier)
        }

        composable(PIN+"/{phoneNumber}",
            arguments = listOf(navArgument("phoneNumber") { type = NavType.StringType })
            ) { backStackEntry ->
            val number = backStackEntry.arguments?.getString("phoneNumber").toString()
            PinScreen(modifier = modifier, phoneNumber = number)
        }

        composable(CONTACT) {
            ContactScreen(modifier = modifier)
        }
    }
}

object Routes {
    const val WELCOME = "welcome"
    const val HOME = "home"
    const val SIGN_UP = "sign_up"
    const val SIGN_IN = "sign_in"
    const val PROFILE = "profile"
    const val SETTINGS = "settings"
    const val PIN = "pin"
    const val CONTACT = "contact"
}
