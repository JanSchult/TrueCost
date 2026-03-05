package com.example.truecost.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.truecost.data.model.LifeCostEntity
import com.example.truecost.data.model.Product
import com.example.truecost.data.model.UserProfile
import com.example.truecost.data.remote.LifeCostRepository
import com.example.truecost.ui.state.TrueCostUiState
import com.example.truecost.util.TrueCostCalculator
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TrueCostViewModel(
    private val calculator: TrueCostCalculator,
    private val repository: LifeCostRepository
) : ViewModel() {

    // ---------- UI STATE ----------

    private val _uiState = MutableStateFlow(TrueCostUiState())
    val uiState: StateFlow<TrueCostUiState> = _uiState.asStateFlow()

    // ---------- HISTORY FLOW ----------

    val history: StateFlow<List<LifeCostEntity>> =
        repository.getAll()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    // ---------- INPUT HANDLER ----------

    fun onIncomeChanged(value: String) {
        _uiState.update { it.copy(monthlyIncome = value) }
    }

    fun onHoursChanged(value: String) {
        _uiState.update { it.copy(monthlyHours = value) }
    }

    fun onProductNameChanged(value: String) {
        _uiState.update { it.copy(productName = value) }
    }

    fun onProductPriceChanged(value: String) {
        _uiState.update { it.copy(productPrice = value) }
    }

    // ---------- CALCULATION ----------

    fun calculate() {

        val currentState = _uiState.value

        val income = currentState.monthlyIncome.toDoubleOrNull()
        val hours = currentState.monthlyHours.toDoubleOrNull()
        val price = currentState.productPrice.toDoubleOrNull()

        if (income == null || hours == null || price == null || hours <= 0) {
            _uiState.update {
                it.copy(
                    resultText = "Bitte gültige Werte eingeben.",
                    isError = true
                )
            }
            return
        }

        val user = UserProfile(
            monthlyIncome = income,
            monthlyWorkingHours = hours
        )

        val product = Product(
            name = currentState.productName,
            price = price
        )

        val result = calculator.calculate(user, product)

        // UI Update
        _uiState.update {
            it.copy(
                resultText = "Das kostet dich ${result.hours}h ${result.minutes}min Lebenszeit.",
                isError = false
            )
        }

        // Persist to Room
        viewModelScope.launch {
            repository.save(
                LifeCostEntity(
                    productName = product.name,
                    productPrice = product.price,
                    lifeHoursDecimal = result.totalHoursDecimal,
                    createdAt = System.currentTimeMillis()
                )
            )
        }
    }

    // ---------- CLEAR HISTORY ----------

    fun clearHistory() {
        viewModelScope.launch {
            repository.clear()
        }
    }

    // ---------- AGGREGATION (BONUS FEATURE) ----------

    fun getTotalLifeHoursThisMonth(): Double {
        val now = System.currentTimeMillis()
        val monthAgo = now - (30L * 24 * 60 * 60 * 1000)

        return history.value
            .filter { it.createdAt >= monthAgo }
            .sumOf { it.lifeHoursDecimal }
    }
}