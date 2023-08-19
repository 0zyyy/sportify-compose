package com.example.sprotify.utils

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import java.lang.Math.tan

class CustomButton(private val angle: Float,width: Float) : Shape {
    override fun createOutline(
        size: androidx.compose.ui.geometry.Size,
        layoutDirection: androidx.compose.ui.unit.LayoutDirection,
        density: Density,
    ): Outline {
        return Outline.Generic(

            Path().apply {
                moveTo(size.width, 0f)
                lineTo(0f, size.height * 0.5000000f)
                lineTo(size.width * 0.03631285f, size.height)
                lineTo(size.width * 0.03631285f, 0f)
                close()
            }
        )
    }
}