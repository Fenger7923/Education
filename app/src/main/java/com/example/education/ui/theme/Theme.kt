package com.example.education.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

@Composable
fun EducationTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = ColorPalette, typography = Typography, content = content)
}

object MineTheme {
    val colors: ColorScheme
        @Composable get() = MaterialTheme.colorScheme

    val typography: Typography
        @Composable get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable get() = MaterialTheme.shapes

    val elevations: Elevations
        @Composable get() = LocalElevations.current
}