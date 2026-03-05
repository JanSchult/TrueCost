package com.example.truecost.ui.composables.dashboard

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HeaderSection(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium
    )
}