package com.example.truecost.ui.composables.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.truecost.data.model.LifeCostEntity

@Composable
fun HistoryList(
    entries: List<LifeCostEntity>,
    onItemClick: (LifeCostEntity) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(entries) { entry ->
            HistoryItemCard(entry = entry, onClick = { onItemClick(entry) })
        }
    }
}