package com.example.lab2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab2.model.HorizontalList
import com.example.lab2.model.Planet

@Composable
fun PlanetHorizontalCard(planet: Planet, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .width(150.dp)
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = planet.name, style = MaterialTheme.typography.titleMedium)
            Text(text = planet.climate, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun HorizontalItem(
    horizontalList: HorizontalList,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "Featured Planets",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = horizontalList.planets,
                key = { planet -> "planet_hz_${planet.id}" }
            ) { planet ->
                PlanetHorizontalCard(planet = planet)
            }
        }
    }
}
