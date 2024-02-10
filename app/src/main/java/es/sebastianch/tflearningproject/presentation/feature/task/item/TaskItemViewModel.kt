package es.sebastianch.tflearningproject.presentation.feature.task.item

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.sebastianch.tflearningproject.presentation.feature.task.vo.TaskVO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TaskItemViewModel @Inject constructor(

) : ViewModel(){
    private val _screenState: MutableStateFlow<State> by lazy { MutableStateFlow(State.Idle) }
    val screenState: StateFlow<State> = _screenState

    sealed interface State {
        data object Idle : State
        data object Loading : State
        data class Success(val taskVO: TaskVO) : State

    }
}