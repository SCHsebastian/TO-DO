package es.sebastianch.tflearningproject.presentation.feature.task.vo

import es.sebastianch.tflearningproject.common.types.PriorityType

data class TaskVO (
    val title: String,
    val description: String,
    val priorityType: PriorityType
)