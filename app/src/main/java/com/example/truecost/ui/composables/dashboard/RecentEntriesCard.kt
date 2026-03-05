package com.example.truecost.ui.composables.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.truecost.data.model.LifeCostEntity
import com.example.truecost.util.formatHours

@Composable
fun RecentEntriesCard(entries: List<LifeCostEntity>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Letzte Berechnungen", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            if (entries.isEmpty()) {
                Text("Noch keine Berechnungen")
            } else {
                entries.forEach { entry ->
                    Text("${entry.productName}: ${entry.lifeHoursDecimal.formatHours()} h")
                }
            }
        }
    }
}