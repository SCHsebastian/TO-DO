package es.sebastianch.tflearningproject.presentation.feature.task.home.state

sealed class TaskHomeUIEvents{
    data object Loading : TaskHomeUIEvents()
    data class Render(val state: TaskHomeState) : TaskHomeUIEvents()
}

sealed class TaskHomeUserEvents{

    data object OnLoading : TaskHomeUserEvents()
    data object OnSendMessageClicked : TaskHomeUserEvents()
    data object OnCloseDialogClicked : TaskHomeUserEvents()
    data class OnMessageTextChanged(val messageText: String) : TaskHomeUserEvents()
}