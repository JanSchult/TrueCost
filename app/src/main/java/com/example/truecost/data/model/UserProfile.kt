package com.example.truecost.data.model


data class UserProfile(
    val monthlyIncome: Double,
    val monthlyWorkingHours: Double
) {
    val hourlyRate: Double
        get() = if (monthlyWorkingHours > 0)
            monthlyIncome / monthlyWorkingHours
        else 0.0
}