package es.sebastianch.tflearningproject.presentation.feature.task.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import es.sebastianch.tflearningproject.presentation.feature.task.home.composable.TaskHomeFAB
import es.sebastianch.tflearningproject.presentation.feature.task.home.composable.TaskHomeTopBar
import es.sebastianch.tflearningproject.presentation.feature.task.home.composable.TaskListItem
import es.sebastianch.tflearningproject.todo.ui.theme.TFLearningProjectTheme

@Composable
fun TaskHomeScreen(
    viewModel: TaskHomeViewModel = hiltViewModel(),
    navigateToTaskScreen: (Long) -> Unit
) {

    val overViewState by viewModel.screenState.collectAsStateWithLifecycle()
    val taskListState by viewModel.listState.collectAsStateWithLifecycle()


    overViewState.let {
        when(it){
            TaskHomeViewModel.State.Idle -> {}
            TaskHomeViewModel.State.Loading -> {}
            is TaskHomeViewModel.State.Success -> if (it.openNewTask) navigateToTaskScreen(-1)
        }
    }

    Scaffold (
        content = {
            LazyColumn(
                modifier = Modifier.padding(it),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(items = taskListState.list, itemContent = {task ->
                    val priorityUI = viewModel.getPriorityUI(task.priority)
                    TaskListItem(title = task.title, description = task.description, priority = priorityUI)
                })
            }
        },
        floatingActionButton = {
            TaskHomeFAB { viewModel.onEvent(TaskHomeViewModel.Event.OnCreateNewTaskFABClick) }
        },
        topBar = {
            TaskHomeTopBar({},{})
        }
    )
}

@Preview
@Composable
fun check(){
    TFLearningProjectTheme {
        TaskHomeScreen{}
    }
}