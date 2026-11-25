package com.example.navapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun UniversalScreen(
    text: String,
    fontSize: TextUnit,
    padding: Dp,
    horizontalAlignment: Alignment.Horizontal,
    verticalArrangement: Arrangement.Vertical,
    changeTextButtonLabel: String,
    onChangeTextClick: () -> Unit,
    navigateButtonLabel: String? = null,
    onNavigateClick: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement
    ) {
        Text(text = text, fontSize = fontSize)
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onChangeTextClick) {
            Text(changeTextButtonLabel)
        }

        if (navigateButtonLabel != null && onNavigateClick != null) {
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = onNavigateClick) {
                Text(navigateButtonLabel)
            }
        }
    }
}
