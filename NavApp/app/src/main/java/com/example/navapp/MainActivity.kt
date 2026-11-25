package com.example.navapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.navapp.ui.theme.NavAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavAppApp()
                }
            }
        }
    }
}

@Composable
fun NavAppApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.CATALOGUE) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach { dest ->
                item(
                    icon = { 
                        Icon(
                            painter = painterResource(dest.icon), 
                            contentDescription = dest.label,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        ) 
                    },
                    label = { Text(dest.label) },
                    selected = dest == currentDestination,
                    onClick = { currentDestination = dest }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                when (currentDestination) {
                    AppDestinations.CATALOGUE -> {
                        CatalogScreen(onNavigate = { currentDestination = AppDestinations.CART })
                    }
                    AppDestinations.CART -> {
                        CartScreen(onNavigate = { currentDestination = AppDestinations.SETTINGS })
                    }
                    AppDestinations.SETTINGS -> {
                        SettingsScreen(onNavigate = { currentDestination = AppDestinations.CATALOGUE })
                    }
                }
            }
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: Int,
) {
    CATALOGUE("Catalogue", R.drawable.catalogue),
    CART("Cart", R.drawable.shopping_cart),
    SETTINGS("Settings", R.drawable.settings),
}