package com.example.truecost.ui.composables.homescreen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ResultSection(
    resultText: String,
    isError: Boolean
) {
    if (resultText.isNotBlank()) {

        Text(
            text = resultText,
            color = if (isError) MaterialTheme.colorScheme.error
            else MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}