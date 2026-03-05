package com.example.truecost.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.truecost.ui.screens.DashboardScreen
import com.example.truecost.ui.screens.HistoryScreen
import com.example.truecost.ui.screens.HomeScreen
import com.example.truecost.viewmodel.TrueCostViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppStart() {

    val navController = rememberNavController()

    val trueCostViewModel: TrueCostViewModel = koinViewModel()

    Scaffold(
        bottomBar = { TrueCostBottomBar(navController) }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = HomeRoute,
            modifier = Modifier.padding(innerPadding)
        ) {

            // ---------------- HOME ----------------

            composable<HomeRoute> {

                val state by trueCostViewModel.uiState.collectAsState()

                HomeScreen(
                    viewModel = trueCostViewModel,
                    onOpenHistory = {
                        navController.navigate(HistoryRoute)
                    },
                    modifier = Modifier
                )
            }

            // ---------------- HISTORY ----------------

            composable<HistoryRoute> {
                val history by trueCostViewModel.history.collectAsState()
                HistoryScreen(
                    entries = history,
                    onItemClick = { entry ->
                        navController.navigate(LifeCostDetailRoute(entry.id))
                    },
                    onClearAll = { trueCostViewModel.clearHistory() }
                )
            }

            // ---------------- DASHBOARD ----------------

            composable<DashboardRoute> {

                val history by trueCostViewModel.history.collectAsState()

                DashboardScreen(
                    history = history,
                    totalHoursThisMonth =
                        trueCostViewModel.getTotalLifeHoursThisMonth()
                )
            }
        }
    }
}