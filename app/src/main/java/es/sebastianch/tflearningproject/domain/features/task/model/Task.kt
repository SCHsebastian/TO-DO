package es.sebastianch.tflearningproject.domain.features.task.model

data class Task (val id: Long, val title:String, val description: String, val priority: Priority)