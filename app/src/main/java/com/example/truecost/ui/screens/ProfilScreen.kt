package com.example.truecost.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.truecost.ui.composables.dashboard.HeaderSection
import com.example.truecost.ui.composables.homescreen.IncomeSection
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.truecost.ui.composables.profil.HourlyWageCard
import com.example.truecost.ui.composables.profil.SaveProfileButton
import com.example.truecost.viewmodel.TrueCostViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: TrueCostViewModel = koinViewModel()
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        HeaderSection(title = "Profil")

        IncomeSection(
            income = state.monthlyIncome,
            hours = state.monthlyHours,
            onIncomeChanged = viewModel::onIncomeChanged,
            onHoursChanged = viewModel::onHoursChanged
        )

        HourlyWageCard(state.monthlyHours.toDoubleOrNull() ?: 0.0)

        SaveProfileButton(
            onClick = viewModel::saveProfile
        )
    }
}