package com.example.truecost.ui.composables.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
fun HistoryItemCard(
    entry: LifeCostEntity,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(entry.productName, style = MaterialTheme.typography.titleMedium)
                Text("Preis: €${entry.productPrice}", style = MaterialTheme.typography.bodyMedium)
            }
            Text(entry.lifeHoursDecimal.formatHours(), style = MaterialTheme.typography.titleSmall)
        }
    }
}