package es.sebastianch.tflearningproject.presentation.feature.task.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.sebastianch.tflearningproject.domain.features.task.model.Task
import es.sebastianch.tflearningproject.domain.features.task.usecase.GetAllTaskUseCase
import es.sebastianch.tflearningproject.domain.features.task.usecase.GetTaskListByPriority
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskHomeViewModel @Inject constructor(
    private val getAllTaskUseCase: GetAllTaskUseCase,
    private val getTaskListByPriority: GetTaskListByPriority
) : ViewModel(){

    private val _screenState: MutableStateFlow<State> by lazy { MutableStateFlow(State.Idle) }
    val screenState: StateFlow<State> = _screenState

    private val _listState: MutableStateFlow<ListState> by lazy { MutableStateFlow(ListState(listOf())) }
    val listState: StateFlow<ListState> = _listState

    fun onEvent(event: Event) {
        when(event){
            is Event.OnCreateNewTaskFABClick -> openScreenCreateNewTask()
            Event.OnLoading -> loadData()
        }
    }

    private fun openScreenCreateNewTask() {
        viewModelScope.launch {
            _screenState.emit(
                State.Success(
                    openNewTask = true
                )
            )
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            getAllTaskUseCase
                .process(GetAllTaskUseCase.Request)
                .collect{
                    _screenState.emit(State.Success())
                }
        }
    }

    sealed interface State {
        data object Idle : State
        data object Loading : State
        data class Success(
            val openNewTask: Boolean = false
        ) : State

    }

    data class ListState(val list: List<Task>)

    sealed interface Event {
        data object OnLoading : Event
        data object OnCreateNewTaskFABClick : Event
    }

}