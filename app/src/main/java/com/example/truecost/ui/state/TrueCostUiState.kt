package com.example.truecost.ui.state

data class TrueCostUiState(
    val monthlyIncome: String = "",
    val monthlyHours: String = "",
    val productName: String = "",
    val productPrice: String = "",
    val resultText: String = "",
    val isError: Boolean = false
)