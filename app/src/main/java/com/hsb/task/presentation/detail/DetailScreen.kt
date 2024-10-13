package com.hsb.task.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.hsb.task.presentation.vm.SharedViewModel
import com.hsb.task.presentation.components.ItemDetailedCard
import com.hsb.task.presentation.components.UiHelpers

object DetailScreen {
    @Composable
    fun DetailScreenUI(drugName: String, viewModel: SharedViewModel = hiltViewModel()) {

        viewModel.getDrugDetails(drugName)?.let { ItemDetailedCard(drug = it) } ?: run {
            UiHelpers.SimpleText(
                text = "Details not found",
                color = Color.Red
            )
        }
    }
}