package com.example.truecost.ui.composables.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IncomeSection(
    income: String,
    hours: String,
    onIncomeChanged: (String) -> Unit,
    onHoursChanged: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        Text("Deine Arbeitsbasis")

        OutlinedTextField(
            value = income,
            onValueChange = onIncomeChanged,
            label = { Text("Monatsnetto (€)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = hours,
            onValueChange = onHoursChanged,
            label = { Text("Arbeitsstunden pro Monat") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}