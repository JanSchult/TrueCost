package com.example.truecost.ui.navigation

import kotlinx.serialization.Serializable
@Serializable
data object HomeRoute

@Serializable
data object HistoryRoute

@Serializable
data object DashboardRoute

@Serializable
data class LifeCostDetailRoute(
    val entryId: Long
)