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
fun ProductSection(
    productName: String,
    productPrice: String,
    onNameChanged: (String) -> Unit,
    onPriceChanged: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        Text("Produkt")

        OutlinedTextField(
            value = productName,
            onValueChange = onNameChanged,
            label = { Text("Produktname") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = productPrice,
            onValueChange = onPriceChanged,
            label = { Text("Preis (€)") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}