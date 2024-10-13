package com.hsb.task.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.hsb.task.presentation.vm.SharedViewModel
import com.hsb.task.presentation.navigation.AppNavigation.NavGraph
import com.hsb.task.presentation.theme.AppTheme.MyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var viewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel = hiltViewModel()
            MyAppTheme {
                val navController = rememberNavController()
                NavGraph(navController, viewModel) // Start the app with the NavGraph
                loadData()

            }
        }

    }

    private fun loadData() {
        viewModel.fetchDrugsFromApi()
    }

}