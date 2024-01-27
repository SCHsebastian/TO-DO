package es.sebastianch.tflearningproject.domain.features.task.model

import es.sebastianch.tflearningproject.common.types.PriorityType

data class Task (val id: Long, val title:String, val description: String, val priority: PriorityType)