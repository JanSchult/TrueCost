package com.example.truecost.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.truecost.data.model.LifeCostEntity
import com.example.truecost.ui.composables.dashboard.HeaderSection
import com.example.truecost.ui.composables.history.ClearAllButton
import com.example.truecost.ui.composables.history.HistoryList

@Composable
fun HistoryScreen(
    entries: List<LifeCostEntity>,
    onItemClick: (LifeCostEntity) -> Unit,
    onClearAll: (() -> Unit)? = null
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        HeaderSection(title = "Historie")

        if (entries.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Noch keine Berechnungen")
            }
        } else {
            HistoryList(entries = entries, onItemClick = onItemClick)
        }

        onClearAll?.let {
            ClearAllButton(it)
        }
    }
}