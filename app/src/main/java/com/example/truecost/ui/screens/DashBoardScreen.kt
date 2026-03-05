package com.example.truecost.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.truecost.data.model.LifeCostEntity
import com.example.truecost.ui.composables.dashboard.AddNewButton
import com.example.truecost.ui.composables.dashboard.HeaderSection
import com.example.truecost.ui.composables.dashboard.MonthlySummaryCard
import com.example.truecost.ui.composables.dashboard.RecentEntriesCard

@Composable
fun DashboardScreen(
    history: List<LifeCostEntity>,
    totalHoursThisMonth: Double,
    onAddNew: (() -> Unit)? = null
) {
    val recent = history.take(3)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        HeaderSection(title = "Dashboard")

        MonthlySummaryCard(totalHoursThisMonth)

        RecentEntriesCard(recent)

        onAddNew?.let {
            AddNewButton(it)
        }
    }
}