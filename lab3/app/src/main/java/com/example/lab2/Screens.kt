package com.example.lab2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab2.model.Character
import com.example.lab2.model.HorizontalList
import com.example.lab2.model.Planet
import com.example.lab2.ui.components.CharacterCard
import com.example.lab2.ui.components.HorizontalItem
import com.example.lab2.ui.components.PlanetCard

@Composable
fun ExploreScreen(viewModel: MainViewModel = viewModel()) {
    val innerNav = rememberNavController()

    NavHost(navController = innerNav, startDestination = "explore_main") {
        composable("explore_main") {
            ExploreMain(
                viewModel = viewModel,
                onOpenDetails = { innerNav.navigate("explore_details") }
            )
        }
        composable("explore_details") {
            ExploreDetails(onBack = { innerNav.popBackStack() })
        }
    }
}

@Composable
fun ExploreMain(viewModel: MainViewModel, onOpenDetails: () -> Unit) {
    val items by viewModel.items.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            items(
                items = items,
                key = { item -> "${item.id}" }
            ) { item ->
                when (item) {
                    is Character -> CharacterCard(character = item)
                    is Planet -> PlanetCard(planet = item)
                    is HorizontalList -> HorizontalItem(horizontalList = item)
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onOpenDetails) {
            Text("Open details")
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ExploreDetails(onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Product details", fontSize = 28.sp)
        Spacer(Modifier.height(12.dp))
        Text("Description of the product goes here.")
        Spacer(Modifier.height(24.dp))
        OutlinedButton(onClick = onBack) { Text("Back") }
    }
}

@Composable
fun FavouritesScreen(onNavigate: () -> Unit) {
    var textState by rememberSaveable { mutableStateOf("Favourites Screen") }

    UniversalScreen(
        text = textState,
        fontSize = 18.sp,
        padding = 32.dp,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        changeTextButtonLabel = "Change text",
        onChangeTextClick = { textState = "The text has been changed!" },
        navigateButtonLabel = "Go to Settings",
        onNavigateClick = onNavigate
    )
}

@Composable
fun SettingsScreen(onNavigate: () -> Unit, viewModel: MainViewModel = viewModel()) {
    val textState by viewModel.textUi.collectAsState()

    UniversalScreen(
        text = textState,
        fontSize = 20.sp,
        padding = 24.dp,
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        changeTextButtonLabel = "Update via ViewModel",
        onChangeTextClick = { viewModel.changeText() },
        navigateButtonLabel = "Go to Explore",
        onNavigateClick = onNavigate
    )
}
