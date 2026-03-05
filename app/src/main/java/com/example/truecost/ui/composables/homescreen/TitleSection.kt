package com.example.truecost.ui.composables.homescreen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TitleSection() {
    Text(
        text = "trueCost",
        style = MaterialTheme.typography.headlineMedium
    )
}