package es.sebastianch.tflearningproject.presentation.feature.task.home.state

import es.sebastianch.tflearningproject.domain.features.task.model.Task

data class TaskHomeState (
    val taskList: List<Task> = listOf()
)