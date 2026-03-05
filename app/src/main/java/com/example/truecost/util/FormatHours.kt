package com.example.truecost.util

import kotlin.math.floor

fun Double.formatHours(): String {
    val h = floor(this).toInt()
    val m = floor((this - h) * 60).toInt()
    return "$h h $m min"
}