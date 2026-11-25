package com.example.navapp

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

@Composable
fun CatalogScreen(onNavigate: () -> Unit) {
    var textState by remember { mutableStateOf("Catalogue Screen (remember)") }

    UniversalScreen(
        text = textState,
        fontSize = 24.sp,
        padding = 16.dp,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        changeTextButtonLabel = "Change Text",
        onChangeTextClick = { textState = "Text changed!" },
        navigateButtonLabel = "Go to Cart",
        onNavigateClick = onNavigate
    )
}

@Composable
fun CartScreen(onNavigate: () -> Unit) {
    var textState by rememberSaveable { mutableStateOf("Cart Screen (rememberSaveable)") }

    UniversalScreen(
        text = textState,
        fontSize = 18.sp,
        padding = 32.dp,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        changeTextButtonLabel = "Change Text",
        onChangeTextClick = { textState = "Text changed!" },
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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        changeTextButtonLabel = "Update via ViewModel",
        onChangeTextClick = { viewModel.changeText() },
        navigateButtonLabel = "Go to Main (Catalogue)",
        onNavigateClick = onNavigate
    )
}
