package com.hsb.task.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

object UiHelpers {
    @Composable
    fun HeadingLargeText(
        text: String,
        modifier: Modifier = Modifier,
        size: TextUnit = 30.sp,
        color: Color = Color.Black
    ) {
        val customTextStyle = MaterialTheme.typography.labelLarge.copy(
            fontSize = size,
            color = color,
            lineHeight = 40.5.sp
        )
        Text(
            text = text,
            style = customTextStyle,
            modifier = modifier,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            softWrap = true
        )
    }



    @Composable
    fun SimpleText(
        text: String,
        modifier: Modifier = Modifier,
        size: TextUnit = 12.sp,
        color: Color = Color.Black,
        textAlign: TextAlign? = TextAlign.Start,
        fontWeight: FontWeight = FontWeight.Normal,

    ) {
        // Greeting message
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            modifier = modifier,
            fontSize = size,
            color = color,
            textAlign = textAlign,
        )
    }

}
