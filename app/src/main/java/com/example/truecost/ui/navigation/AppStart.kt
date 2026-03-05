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
import com.example.truecost.ui.screens.ProfileScreen
import com.example.truecost.viewmodel.TrueCostViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppStart() {

    val navController = rememberNavController()

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


                composable<HomeRoute> {
                    val viewModel: TrueCostViewModel = koinViewModel()
                    val state by viewModel.uiState.collectAsState()

                    HomeScreen(
                        onOpenHistory = {
                            navController.navigate(HistoryRoute)
                        }
                    )
                }


                // ---------------- HISTORY ----------------

            composable<HistoryRoute> {

                val viewModel: TrueCostViewModel = koinViewModel()
                val history by viewModel.history.collectAsState()

                HistoryScreen(
                    entries = history,
                    onItemClick = { entryId ->
                      //  navController.navigate(
                      //      LifeCostDetailRoute(entryId)
                        //     )
                    },
                    onClearAll = viewModel::clearHistory
                )
            }

            // ---------------- DASHBOARD ----------------

            composable<DashboardRoute> {

                val viewModel: TrueCostViewModel = koinViewModel()
                val history by viewModel.history.collectAsState()

                DashboardScreen(
                    history = history,
                    totalHoursThisMonth =
                        viewModel.getTotalLifeHoursThisMonth(),
                    onAddNew = {
                        navController.navigate(HomeRoute)
                    }
                )
            }

            // ---------------- PROFILE ----------------

            composable<ProfileRoute> {

                val viewModel: TrueCostViewModel = koinViewModel()
                val state by viewModel.uiState.collectAsState()

                ProfileScreen()
            }
        }
    }
}}