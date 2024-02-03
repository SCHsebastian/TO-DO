package es.sebastianch.tflearningproject.presentation.feature.task.home.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import es.sebastianch.tflearningproject.R
import es.sebastianch.tflearningproject.presentation.feature.task.home.TaskHomeViewModel
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.TaskHomeUIEvents
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.TaskHomeUserEvents
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
            listFAB(onCreateNewTaskFABClick)
        }
    )
}

@Composable
fun listFAB(onFABClick: () -> Unit){
    FloatingActionButton(
        onClick = { onFABClick.invoke() }
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = stringResource(id = R.string.add_task_button))
    }
}

@Preview
@Composable
fun check(){
    ListScreen(onCreateNewTaskFABClick = { /*TODO*/ }, onTaskEditButtonClick = { /*TODO*/ }) {

    }
}