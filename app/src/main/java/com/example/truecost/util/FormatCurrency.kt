package com.example.truecost.util

fun Double.formatCurrency(digits: Int = 2): String {
    return "%.${digits}f".format(this)
}