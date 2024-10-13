package com.hsb.task.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hsb.task.presentation.vm.SharedViewModel
import com.hsb.task.domain.utils.Extensions.name
import com.hsb.task.presentation.detail.DetailScreen
import com.hsb.task.presentation.detail.DetailScreen.DetailScreenUI
import com.hsb.task.presentation.home.HomeScreen
import com.hsb.task.presentation.home.HomeScreen.HomeScreenUI
import com.hsb.task.presentation.login.LoginScreen
import com.hsb.task.presentation.login.LoginScreen.LoginScreenUI

object AppNavigation {
    @Composable
    fun NavGraph(navController: NavHostController, viewModel: SharedViewModel) {
        NavHost(navController = navController, startDestination = LoginScreen.name())
        {
            composable(LoginScreen.name()) { LoginScreenUI(navController,viewModel) }
            composable(HomeScreen.name()) { HomeScreenUI(navController,viewModel) }
            composable(DetailScreen.name() + "/{drugName}") { backStackEntry ->
                val drugName = backStackEntry.arguments?.getString("drugName")
                drugName?.let {
                    DetailScreenUI(it,viewModel)
                }
            }
        }
    }
}

