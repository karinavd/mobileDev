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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CatalogScreen() {
    val innerNav = rememberNavController()

    NavHost(navController = innerNav, startDestination = "catalog_main") {
        composable("catalog_main") {
            CatalogMain(onOpenDetails = { innerNav.navigate("catalog_details") })
        }
        composable("catalog_details") {
            CatalogDetails(onBack = { innerNav.popBackStack() })
        }
    }
}
@Composable
fun CatalogMain(onOpenDetails: () -> Unit) {
    var textState by remember { mutableStateOf("Catalogue") }

    UniversalScreen(
        text = textState,
        fontSize = 24.sp,
        padding = 16.dp,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        changeTextButtonLabel = "Change text",
        onChangeTextClick = { textState = "The text has been changed!" },
        navigateButtonLabel = "Open details",
        onNavigateClick = onOpenDetails
    )
}

@Composable
fun CatalogDetails(onBack: () -> Unit) {
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
fun CartScreen(onNavigate: () -> Unit) {
    var textState by rememberSaveable { mutableStateOf("Cart Screen") }

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
        navigateButtonLabel = "Go to Catalogue",
        onNavigateClick = onNavigate
    )
}
