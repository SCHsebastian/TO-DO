package es.sebastianch.tflearningproject.presentation.feature.task.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.TaskHomeState
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.InitUserEvents
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskHomeViewModel @Inject constructor() : ViewModel(){

    private val _screenState: MutableState<TaskHomeState> = mutableStateOf(TaskHomeState())
    val screenState: State<TaskHomeState>
        get() = _screenState

    fun onEvent(event: InitUserEvents) {
        when(event){
            is InitUserEvents.OnMessageTextChanged -> {reloadStateWithMessage(event.messageText)}
            is InitUserEvents.OnSendMessageClicked -> openDialogMessage()
            InitUserEvents.OnCloseDialogClicked -> closeDialogMessage()
        }
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
}