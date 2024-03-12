package es.sebastianch.tflearningproject.presentation.feature.task.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.sebastianch.tflearningproject.domain.common.Result
import es.sebastianch.tflearningproject.domain.features.task.usecase.GetTaskByIdUseCase
import es.sebastianch.tflearningproject.presentation.feature.task.vo.PriorityDecorator
import es.sebastianch.tflearningproject.presentation.feature.task.vo.TaskVO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TaskItemViewModel @Inject constructor(
    private val getTaskUseCase: GetTaskByIdUseCase,
    private val priorityDecorator: PriorityDecorator,
) : ViewModel(){

    fun obtainTask(taskId: Long){
        getTaskUseCase
            .execute(GetTaskByIdUseCase.Request(taskId))
            .onEach {
                it as Result.Success
                val priorityVO = priorityDecorator.applyStyle(it.data.task.priority)
                val vo = TaskVO(it.data.task.title, it.data.task.description, priorityVO)
                _screenState.update { State.Success(vo) }
            }.launchIn(viewModelScope)

    }

    private val _screenState: MutableStateFlow<State> by lazy { MutableStateFlow(State.Idle) }
    val screenState: StateFlow<State> = _screenState

    sealed interface State {
        data object Idle : State
        data object Loading : State
        data class Success(val taskVO: TaskVO) : State

    }
}