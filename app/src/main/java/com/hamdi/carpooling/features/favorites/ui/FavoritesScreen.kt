@file:OptIn(ExperimentalMaterial3Api::class)

package com.hamdi.carpooling.features.favorites.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.hamdi.carpooling.core.navigation.LocalNavController

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    // TODO: Create dynamic favorites list
    favorites: List<String> = listOf(
        "Trip to Tunis",
        "Evening ride to Sfax",
        "Morning ride to Monastir"
    )
) {
    val navController = LocalNavController.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Favorites",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF007AFF)
                )
            )
        },
        containerColor = Color.Transparent
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF4FACFE), Color(0xFF00F2FE))
                    )
                )
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            if (favorites.isEmpty()) {
                Text(
                    text = "You have no favorite rides yet.",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    favorites.forEach { item ->
                        FavoriteCard(item)
                    }
                }
            }
        }
    }
}

@Composable
fun FavoriteCard(title: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 6.dp,
        color = Color.White.copy(alpha = 0.95f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Favorite",
                tint = Color(0xFFFFC107),
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewFavoritesScreen() {
    val fakeNavController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides fakeNavController) {
        FavoritesScreen(
            favorites = listOf(
                "Trip to Tunis",
                "Evening ride to Sfax",
                "Morning ride to Monastir"
            )
        )
    }
}

