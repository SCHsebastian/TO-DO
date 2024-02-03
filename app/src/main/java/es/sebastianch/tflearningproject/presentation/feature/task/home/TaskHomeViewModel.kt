package es.sebastianch.tflearningproject.presentation.feature.task.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.sebastianch.tflearningproject.domain.features.task.usecase.GetAllTaskUseCase
import es.sebastianch.tflearningproject.domain.features.task.usecase.GetTaskListByPriority
import es.sebastianch.tflearningproject.presentation.common.MVIEventType
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
class TaskHomeViewModel @Inject constructor(
    private val getAllTaskUseCase: GetAllTaskUseCase,
    private val getTaskListByPriority: GetTaskListByPriority
) : ViewModel(){

    private val _screenState: MutableStateFlow<TaskHomeState> by lazy { MutableStateFlow(TaskHomeState()) }
    val screenState: StateFlow<TaskHomeState> = _screenState

    private val _uiEvents: MutableSharedFlow<MVIEventType.UI> = MutableSharedFlow()
    val uiEvents: SharedFlow<MVIEventType.UI>
        get() = _uiEvents.asSharedFlow()

    fun onEvent(event: MVIEventType.User) {
        when(event){
            is TaskHomeUserEvents.OnCreateNewTaskFABClick -> openScreenCreateNewTask(event.taskId)
            TaskHomeUserEvents.OnLoading -> loadData()
        }
    }

    private fun openScreenCreateNewTask(taskId: Long) {
        emitEvent(TaskHomeUIEvents.OpenScreenNewTask(taskId))
    }

    private fun loadData() {
        viewModelScope.launch {
            getAllTaskUseCase
                .process(GetAllTaskUseCase.Request)
                .collect{
                    _screenState.emit(TaskHomeState())
                }
        }
    }

    private fun reloadStateWithMessage(messageText: String) {
        viewModelScope.launch {
            emitState {
                TaskHomeState()
            }
        }
    }

    private fun openDialogMessage() {
        viewModelScope.launch{
            emitState {
                TaskHomeState()
            }
        }
    }

    private fun closeDialogMessage() {
        viewModelScope.launch{
            emitState {
                TaskHomeState()
            }
        }
    }

    private fun emitState(state: TaskHomeState.() -> TaskHomeState) {
        _screenState.value = state.invoke(screenState.value)
    }

    private fun emitEvent(event: MVIEventType.UI){
        viewModelScope.launch {
            _uiEvents.emit(event)
        }
    }
}