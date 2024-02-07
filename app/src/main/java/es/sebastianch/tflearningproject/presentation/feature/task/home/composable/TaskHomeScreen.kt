package es.sebastianch.tflearningproject.presentation.feature.task.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.sebastianch.tflearningproject.common.types.PriorityType
import es.sebastianch.tflearningproject.domain.features.task.model.Task
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
            {},
            taskList = it.value.taskList
        )
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
    onTaskDeleteButtonClick: () -> Unit,
    taskList: List<Task>
) {
    Scaffold (
        content = {
            LazyColumn(
                modifier = Modifier.padding(it),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
               items(items = taskList, itemContent = {task ->
                   TaskListItem(title = task.title, description = task.description, priorityType = task.priority)
               })
           }
        },
        floatingActionButton = {
            TaskHomeFAB(onCreateNewTaskFABClick)
        },
        topBar = {
            TaskHomeTopBar({},{})
        }
    )
}

@Preview
@Composable
fun check(){
    val taskList = listOf(
        Task(0, "Titulo", description = "descripcion", priority = PriorityType.LOW),
        Task(1, "Titulo", description = "descripcion", priority = PriorityType.MEDIUM),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(2, "Titulo", description = "descripcion", priority = PriorityType.HIGH),
        Task(3, "Titulo", description = "descripcion", priority = PriorityType.NONE),
        Task(4, "Titulo", description = "descripcion", priority = PriorityType.LOW),
        Task(5, "Titulo", description = "descripcion", priority = PriorityType.LOW),
        Task(6, "Titulo", description = "descripcion", priority = PriorityType.LOW),
    )
    TFLearningProjectTheme {
        ListScreen(onCreateNewTaskFABClick = {},
            onTaskEditButtonClick = {},
            {},
            taskList
        )
    }
}