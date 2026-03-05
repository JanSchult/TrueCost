package com.example.truecost.util

import com.example.truecost.data.model.LifeCost
import com.example.truecost.data.model.Product
import com.example.truecost.data.model.UserProfile
import kotlin.math.floor

class TrueCostCalculator {

    fun calculate(user: UserProfile, product: Product): LifeCost {

        val hourlyRate = user.hourlyRate

        if (hourlyRate <= 0) {
            return LifeCost(0, 0, 0.0)
        }

        val totalHours = product.price / hourlyRate

        val hours = floor(totalHours).toInt()
        val minutes = floor((totalHours - hours) * 60).toInt()

        return LifeCost(
            hours = hours,
            minutes = minutes,
            totalHoursDecimal = totalHours
        )
    }
}