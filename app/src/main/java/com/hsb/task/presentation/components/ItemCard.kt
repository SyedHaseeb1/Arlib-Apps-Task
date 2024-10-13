package com.hsb.task.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hsb.task.data.model.Drug
import com.hsb.task.data.model.Lab

val mainHeadingColor = Color(0xFF467E3F)

@Composable
fun ItemCard(drug: Drug, onClick: (() -> Unit)? = null) {

    Box(modifier = Modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick?.invoke() },
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp,
                pressedElevation = 12.dp
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)

            ) {
                // Drug name
                UiHelpers.HeadingLargeText(
                    text = drug.name,
                    size = 16.sp,
                    color = mainHeadingColor
                )
                Spacer(modifier = Modifier.height(12.dp))

                // Drug dose (if available)
                drug.dose?.let {
                    UiHelpers.SimpleText(text = "Dose: $it", color = Color.DarkGray)

                    Spacer(modifier = Modifier.height(12.dp))
                }

                // Drug strength (if available)
                drug.strength?.let {
                    UiHelpers.SimpleText(text = "Strength: $it", color = Color.DarkGray)
                }
            }
        }
    }

}

@Composable
fun ItemCard(lab: Lab, onClick: () -> Unit) {

    Box(modifier = Modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() },
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp,
                pressedElevation = 12.dp
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                // Name of the lab test
                lab.name?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = mainHeadingColor,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))

                // Value of the lab test
                lab.value?.let {
                    Text(
                        text = "Value: $it",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                // Normal range of the lab test
                lab.normalRange?.let {
                    Text(
                        text = "Normal Range: $it",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                    )
                }

                // Result status of the lab test
                lab.result.takeIf {
                    it.isNotEmpty()
                }?.let {
                    Text(
                        text = "Result: $it",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Red)
                    )
                }
            }
        }
    }
}


@Composable
fun ItemDetailedCard(drug: Drug, onClick: (() -> Unit)? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 48.dp) // More generous padding
            .clickable { onClick?.invoke() },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation
            = 8.dp,
            pressedElevation = 12.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 32.dp) // Internal padding
        ) {
            // Drug name
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                UiHelpers.HeadingLargeText(
                    text = drug.name,
                    size = 20.sp, // Even larger font
                    color = mainHeadingColor
                )
                // Add an optional drug icon here
                // Icon(imageVector = drugIcon, contentDescription = "Drug icon") // Example
            }
            Spacer(modifier = Modifier.height(24.dp))

            // Drug dose (if available)
            drug.dose?.let {
                UiHelpers.SimpleText(text = "Dose: $it", color = Color.DarkGray)
            }

            if (drug.dose != null && drug.strength != null) {
                Spacer(modifier = Modifier.height(16.dp)) // Slightly increased spacing
            }

            // Drug strength (if available)
            drug.strength?.let {
                UiHelpers.SimpleText(text = "Strength: $it", color = Color.DarkGray)
            }
        }
    }
}

