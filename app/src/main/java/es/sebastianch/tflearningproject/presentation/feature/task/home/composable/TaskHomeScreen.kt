package es.sebastianch.tflearningproject.presentation.feature.task.home.composable

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import es.sebastianch.tflearningproject.presentation.feature.task.home.TaskHomeViewModel
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.TaskHomeUIEvents
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.TaskHomeUserEvents
import es.sebastianch.tflearningproject.todo.ui.theme.TFLearningProjectTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TaskHomeScreen(
    viewModel: TaskHomeViewModel,
    navigateToTaskScreen: (Long) -> Unit
) {
    viewModel.screenState.collectAsState().let {
        ListScreen(
            onCreateNewTaskFABClick = {viewModel.onEvent(TaskHomeUserEvents.OnCreateNewTaskFABClick(taskId = -1))},
            {},
            {})
    }

    LaunchedEffect(Unit){
        viewModel.uiEvents.collectLatest { event ->
            when(event){
                TaskHomeUIEvents.Loading -> TODO()
                is TaskHomeUIEvents.OpenScreenNewTask -> navigateToTaskScreen(event.taskId)
            }
        }
    }



}

@Composable
fun ListScreen(
    onCreateNewTaskFABClick: () -> Unit,
    onTaskEditButtonClick: () -> Unit,
    onTaskDeleteButtonClick: () -> Unit
) {
    Scaffold (
        content = {
                  it.calculateBottomPadding()
        },
        floatingActionButton = {
            TaskHomeFAB(onCreateNewTaskFABClick)
        },
        topBar = {
            TaskHomeTopBar()
        }
    )
}

@Preview
@Composable
fun check(){
    TFLearningProjectTheme {
        ListScreen(onCreateNewTaskFABClick = { /*TODO*/ }, onTaskEditButtonClick = { /*TODO*/ }) {
        }
    }
}