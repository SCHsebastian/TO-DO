package es.sebastianch.tflearningproject.presentation.feature.task.home.state

sealed class InitUIEvents

sealed class InitUserEvents{
    data object OnSendMessageClicked : InitUserEvents()
    data object OnCloseDialogClicked : InitUserEvents()
    data class OnMessageTextChanged(val messageText: String) : InitUserEvents()
}