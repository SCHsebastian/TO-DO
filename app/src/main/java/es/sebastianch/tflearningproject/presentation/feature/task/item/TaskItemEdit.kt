package es.sebastianch.tflearningproject.presentation.feature.task.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import es.sebastianch.tflearningproject.presentation.common.navigation.task.TaskAction
import es.sebastianch.tflearningproject.presentation.feature.task.home.TaskHomeViewModel
import es.sebastianch.tflearningproject.presentation.feature.task.vo.PriorityItem
import es.sebastianch.tflearningproject.presentation.feature.task.vo.PrioritySimpleItem
import es.sebastianch.tflearningproject.presentation.feature.task.vo.PriorityVO
import es.sebastianch.tflearningproject.todo.ui.theme.TFLearningProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskEditScreen(
    viewModel: TaskItemViewModel = hiltViewModel(),
    taskId: Long,
    backNavigation: (TaskAction) -> Unit
) {

    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    when (screenState){
        TaskItemViewModel.State.Idle -> TODO()
        TaskItemViewModel.State.Loading -> TODO()
        is TaskItemViewModel.State.Success -> {

        }
    }

    var taskDescriptionModifiable by remember { mutableStateOf(taskItem.description) }
    var taskPriorityModifiable by remember { mutableStateOf(taskItem.priority) }
    var dropDownExpanded by remember { mutableStateOf(false) }
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(horizontal = 8.dp),
                title = {
                    Text(text = taskItem.title)
                },
                actions = {
                    Box(
                        modifier = Modifier.clickable { /*Open */ }
                    ){
                        PrioritySimpleItem(priorityType = taskItem.priority)
                        DropdownMenu(
                            expanded = dropDownExpanded,
                            onDismissRequest = { dropDownExpanded = false }
                        ) {
                            listOf<PriorityVO>().forEach{
                                DropdownMenuItem(
                                    text = { PriorityItem(it) },
                                    onClick = { taskPriorityModifiable = it })
                            }
                        }
                    }
                }
            )
                 },
        floatingActionButton = {
            OutlinedButton(onClick = {/*SAVE*/}) {
                Icon(imageVector = Icons.Rounded.Lock , contentDescription = "DESCRIPTION")
            }
        }
    ){
        val baseModifier = Modifier.padding(it)
        Box(modifier = baseModifier.padding(4.dp)){
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                value = taskItem.description,
                onValueChange = { newDescription -> taskDescriptionModifiable = newDescription }
            )
        }
    }
}

@Preview
@Composable
fun TaskScreenEditPreview() {
    TFLearningProjectTheme {
        TaskEditScreen (taskId = 1){}
    }
}