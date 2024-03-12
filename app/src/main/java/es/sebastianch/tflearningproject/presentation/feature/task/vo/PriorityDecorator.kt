package es.sebastianch.tflearningproject.presentation.feature.task.vo

import androidx.compose.ui.graphics.Color
import es.sebastianch.tflearningproject.R
import es.sebastianch.tflearningproject.domain.features.task.model.Priority
import es.sebastianch.tflearningproject.presentation.common.compose.Decorator

class PriorityDecorator: Decorator<Priority, PriorityVO> {
    override fun applyStyle(element: Priority): PriorityVO =
        when(element){
            Priority.HIGH -> PriorityVO(
                title = R.string.high_priority,
                color = Color.Red
            )
            Priority.MEDIUM -> PriorityVO(
                title = R.string.medium_priority,
                color = Color.Yellow
            )
            Priority.LOW -> PriorityVO(
                title = R.string.low_priority,
                color = Color.Green
            )
            Priority.NONE -> PriorityVO(
                title = R.string.none_priority,
                color = Color.White
            )
        }
}