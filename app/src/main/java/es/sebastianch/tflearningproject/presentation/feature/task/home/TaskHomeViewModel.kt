package es.sebastianch.tflearningproject.presentation.feature.task.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.TaskHomeState
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.TaskHomeUIEvents
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.TaskHomeUserEvents
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskHomeViewModel @Inject constructor() : ViewModel(){

    private val _screenState: MutableStateFlow<TaskHomeState> by lazy { MutableStateFlow(TaskHomeState()) }
    val screenState: StateFlow<TaskHomeState> = _screenState

    private val _uiEvents: MutableSharedFlow<TaskHomeUIEvents> = MutableSharedFlow()
    val uiEvents: SharedFlow<TaskHomeUIEvents>
        get() = _uiEvents.asSharedFlow()

    fun onEvent(event: TaskHomeUserEvents) {
        when(event){
            is TaskHomeUserEvents.OnMessageTextChanged -> reloadStateWithMessage(event.messageText)
            is TaskHomeUserEvents.OnSendMessageClicked -> openDialogMessage()
            TaskHomeUserEvents.OnCloseDialogClicked -> closeDialogMessage()
            TaskHomeUserEvents.OnLoading -> loadData()
        }
    }

    private fun loadData() {
        //TODO
    }

    private fun reloadStateWithMessage(messageText: String) {
        viewModelScope.launch {
            emitState {
                TaskHomeState(message = messageText)
            }
        }
    }

    private fun openDialogMessage() {
        viewModelScope.launch{
            emitState {
                TaskHomeState(message = screenState.value.message, showMessage = true)
            }
        }
    }

    private fun closeDialogMessage() {
        viewModelScope.launch{
            emitState {
                TaskHomeState(showMessage = false)
            }
        }
    }

    private fun emitState(state: TaskHomeState.() -> TaskHomeState) {
        _screenState.value = state.invoke(screenState.value)
    }

    private fun emitEvent(event: TaskHomeUIEvents){
        viewModelScope.launch {
            _uiEvents.emit(event)
        }
    }
}