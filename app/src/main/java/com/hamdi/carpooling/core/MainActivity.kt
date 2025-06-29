package com.hamdi.carpooling.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hamdi.carpooling.core.navigation.AppNavigation
import com.hamdi.carpooling.core.navigation.LocalMainViewModel
import com.hamdi.carpooling.core.navigation.LocalNavController
import com.hamdi.carpooling.core.navigation.LocalSnackbarHostState
import com.hamdi.carpooling.core.navigation.Routes.CONTACT
import com.hamdi.carpooling.core.navigation.Routes.DASHBOARD
import com.hamdi.carpooling.core.navigation.Routes.FAVORITES
import com.hamdi.carpooling.core.navigation.Routes.HOME
import com.hamdi.carpooling.core.navigation.Routes.NOTIFICATIONS
import com.hamdi.carpooling.core.navigation.Routes.PROFILE
import com.hamdi.carpooling.core.navigation.Routes.SETTINGS
import com.hamdi.carpooling.core.presentation.MainViewModel
import com.hamdi.carpooling.core.theme.CarPoolingTheme
import com.hamdi.carpooling.features.home.ui.FooterSection
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            val snackbarHostState = remember { SnackbarHostState() }
            val mainViewModel: MainViewModel = hiltViewModel()

            // List of screens that should display the footer
            val showFooter = currentRoute in listOf(
                HOME,
                PROFILE,
                SETTINGS,
                CONTACT,
                DASHBOARD,
                NOTIFICATIONS,
                FAVORITES
            )

            CarPoolingTheme {
                CompositionLocalProvider(
                    LocalNavController provides navController,
                    LocalSnackbarHostState provides snackbarHostState,
                    LocalMainViewModel provides mainViewModel
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                            if (showFooter)
                                FooterSection()
                        },
                    ) { innerPadding ->
                        AppNavigation(Modifier.padding(innerPadding))
                    }

                    val messageToShow = LocalMainViewModel.current.snackbarMessage.value
                    LaunchedEffect(messageToShow) {
                        messageToShow?.let {
                            snackbarHostState.showSnackbar(it)
                            mainViewModel.clearSnackbarMessage()
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        SnackbarHost(
                            hostState = snackbarHostState,
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                        ) { data ->
                            Snackbar(
                                shape = RoundedCornerShape(12.dp),
                                containerColor = Color(0xFF005F8F).copy(alpha = 0.9f),
                                contentColor = Color.White,
                                actionContentColor = Color(0xFF00E5FF),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                dismissAction = {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Dismiss",
                                        tint =  Color(0xFF800020),
                                        modifier = Modifier
                                            .padding(end = 8.dp)
                                            .clickable {
                                                data.dismiss()
                                            }
                                    )
                                },
                            ) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center
                                    ),
                                    text = data.visuals.message
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}