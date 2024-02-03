package es.sebastianch.tflearningproject.presentation.feature.task.home.state

import es.sebastianch.tflearningproject.presentation.common.MVIEventType

sealed class TaskHomeUIEvents : MVIEventType.UI{
    data object Loading : TaskHomeUIEvents()
    data class OpenScreenNewTask(val taskId: Long) : TaskHomeUIEvents()
}

sealed class TaskHomeUserEvents: MVIEventType.User{

    data object OnLoading : TaskHomeUserEvents()
    data class OnCreateNewTaskFABClick(val taskId: Long) : TaskHomeUserEvents()
}