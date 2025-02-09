package com.karan.lilcloud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.karan.lilcloud.composeUI.ManageLocations
import com.karan.lilcloud.composeUI.WeatherScreen
import com.karan.lilcloud.viewModel.WeatherViewModel


@Composable
fun NavGraph(
    viewModel: WeatherViewModel,
    navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.name
    ) {
        composable(
            route = Screens.Home.name
        ) {
            WeatherScreen(viewModel, navController)
        }

        composable(
            route = Screens.ManageLocations.name
        ) {
            ManageLocations(viewModel)
        }
    }
}