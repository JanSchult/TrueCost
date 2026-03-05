package com.example.truecost.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.truecost.ui.composables.homescreen.CalculateButton
import com.example.truecost.ui.composables.homescreen.ProductSection
import com.example.truecost.ui.composables.homescreen.ResultSection
import com.example.truecost.ui.composables.homescreen.TitleSection
import com.example.truecost.viewmodel.TrueCostViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onOpenHistory: () -> Unit
) {

    val viewModel: TrueCostViewModel = koinViewModel()
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        TitleSection()

        ProductSection(
            productName = state.productName,
            productPrice = state.productPrice,
            onNameChanged = viewModel::onProductNameChanged,
            onPriceChanged = viewModel::onProductPriceChanged
        )

        CalculateButton(
            onClick = viewModel::calculate
        )

        ResultSection(
            resultText = state.resultText,
            isError = state.isError
        )

        Button(onClick = onOpenHistory) {
            Text("Zur Historie")
        }
    }
}