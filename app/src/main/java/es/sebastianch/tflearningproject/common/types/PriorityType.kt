package es.sebastianch.tflearningproject.common.types

import androidx.compose.ui.graphics.Color

enum class PriorityType(val color: Color) {
    HIGH(Color.Red),
    MEDIUM(Color.Yellow),
    LOW(Color.Green),
    NONE(Color.White)
}