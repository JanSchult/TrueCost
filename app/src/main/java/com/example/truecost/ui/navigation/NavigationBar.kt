package com.example.truecost.ui.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TrueCostBottomBar(navController: NavController) {

    NavigationBar {

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(HomeRoute) },
            label = { Text("Home") },
            icon = {}
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(HistoryRoute) },
            label = { Text("History") },
            icon = {}
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(DashboardRoute) },
            label = { Text("Dashboard") },
            icon = {}
        )
    }
}