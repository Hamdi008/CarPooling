package com.hamdi.carpooling.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.hamdi.carpooling.core.navigation.AppNavigation
import com.hamdi.carpooling.core.navigation.LocalNavController
import com.hamdi.carpooling.core.theme.CarPoolingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            CarPoolingTheme {
                CompositionLocalProvider(LocalNavController provides navController){
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        AppNavigation(Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}