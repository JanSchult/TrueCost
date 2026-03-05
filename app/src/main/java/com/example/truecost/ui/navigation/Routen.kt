package com.example.truecost.ui.navigation

import com.example.truecost.data.model.LifeCostEntity
import kotlinx.serialization.Serializable
@Serializable
object HomeRoute

@Serializable
object HistoryRoute

@Serializable
 object DashboardRoute
@Serializable
object ProfileRoute
@Serializable
data class LifeCostDetailRoute(
    val entryId: LifeCostEntity
)