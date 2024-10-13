package com.hsb.task.presentation.theme


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object AppTheme {
    // Define your color palette
    private val LightColorPalette = lightColorScheme(
        primary = Color(0xFF6200EE),
        onPrimary = Color.White,
        secondary = Color(0xFF03DAC5),
        onSecondary = Color.Black,
        background = Color(0xFFFFFFFF),
        onBackground = Color.Black,
        surface = Color(0xFFFFFFFF),
        onSurface = Color.Black,
    )

    private val DarkColorPalette = darkColorScheme(
        primary = Color(0xFFBB86FC),
        onPrimary = Color.Black,
        secondary = Color(0xFF03DAC5),
        onSecondary = Color.Black,
        background = Color(0xFF121212),
        onBackground = Color.White,
        surface = Color(0xFF121212),
        onSurface = Color.White,
    )

    // Define your custom shapes
    private val Shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    // Theme composable function
    @Composable
    fun MyAppTheme(
        darkTheme: Boolean = false, // Set default theme here
        content: @Composable () -> Unit
    ) {
        val colorScheme = if (darkTheme) DarkColorPalette else LightColorPalette

        MaterialTheme(
            colorScheme = colorScheme,
            typography = MaterialTheme.typography,
            shapes = Shapes,
            content = content
        )
    }
}