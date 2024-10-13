package com.hsb.task.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hsb.task.data.model.Lab
import com.hsb.task.data.model.ProcessedData
import com.hsb.task.presentation.vm.SharedViewModel
import com.hsb.task.domain.utils.Extensions.greetingMessage
import com.hsb.task.domain.utils.Extensions.name
import com.hsb.task.presentation.components.ItemCard
import com.hsb.task.presentation.components.UiHelpers
import com.hsb.task.presentation.detail.DetailScreen
import com.hsb.extensions_hsb.utils.globalextensions.Extensions.logIt

object HomeScreen {
    @Composable
    fun HomeScreenUI(
        navController: NavHostController? = null,
        viewModel: SharedViewModel = hiltViewModel()
    ) {
        val context = LocalContext.current
        LaunchedEffect(Unit) {
            viewModel.text.logIt("Main")
        }
        val userName = viewModel.userName.value
        val drugResult by viewModel.drugsLiveListData.observeAsState(
            Result.success(ProcessedData(emptyList(), emptyList())) // Adjusted to ProcessedData
        )
        Column(
            modifier = Modifier
                .fillMaxSize() // Fills the entire screen
                .verticalScroll(rememberScrollState()) // Enables vertical scrolling
                .padding(10.dp)
        ) {
            // Greeting message
            UiHelpers.HeadingLargeText(
                text = greetingMessage(userName),
                modifier = Modifier.padding(10.dp),
                size = 40.sp // Adjust size as needed
            )


            // Category Heading
            UiHelpers.HeadingLargeText(
                text = "Your Medications",
                modifier = Modifier.padding( 10.dp),
                size = 24.sp
            )

            // Handle the state (Success or Failure)
            when {
                drugResult.isSuccess -> {
                    val combinedData =
                        drugResult.getOrDefault(ProcessedData(emptyList(), emptyList()))
                    viewModel.drugsList.apply {
                        clear()
                        addAll(combinedData.drugs)
                    }
                    // Diabetes Section
                    if (combinedData.drugs.any { it.problemName == "Diabetes" }) {
                        SectionHeader("Diabetes")
                        LazyRow(
                            modifier = Modifier.padding(bottom = 16.dp)
                        ) {
                            items(combinedData.drugs.filter { it.problemName == "Diabetes" }) { drug ->
                                ItemCard(drug = drug) {
                                    navController?.navigate("${DetailScreen.name()}/${drug.name}")
                                }
                            }
                        }

                        // Labs for Diabetes
                        SectionLabs(combinedData.labs.filter { it.problemName == "Diabetes" })
                    }

                    // Asthma Section
                    if (combinedData.drugs.any { it.problemName == "Asthma" }) {
                        SectionHeader(combinedData.drugs.last().problemName)
                        LazyRow(
                            modifier = Modifier.padding(bottom = 16.dp)
                        ) {
                            items(combinedData.drugs.filter { it.problemName == "Asthma" }) { drug ->
                                ItemCard(drug = drug) {
                                    navController?.navigate("${DetailScreen.name()}/${drug.name}")
                                }
                            }
                        }

                        // Labs for Asthma
                        SectionLabs(combinedData.labs.filter { it.problemName == "Asthma" })
                    }
                }

                drugResult.isFailure -> {
                    Text("Failed to load data", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }

    @Composable
    fun SectionHeader(title: String) {
        UiHelpers.HeadingLargeText(
            text = title,
            modifier = Modifier.padding(10.dp),
            size = 22.sp
        )
    }

    @Composable
    fun SectionLabs(labs: List<Lab>) {
        if (labs.isNotEmpty()) {
            Column {
                SectionHeader("Labs") // Add a header for the labs section
                labs.forEach { lab ->
                    ItemCard(lab = lab) {
                        // Navigate to detail screen if needed
                    }
                }
            }
        } else {
            Text("No labs found.", modifier = Modifier.padding(16.dp))
        }
    }

}
