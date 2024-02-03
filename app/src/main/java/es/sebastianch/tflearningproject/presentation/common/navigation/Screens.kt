package es.sebastianch.tflearningproject.presentation.common.navigation

import androidx.navigation.NavHostController
import es.sebastianch.tflearningproject.presentation.common.navigation.task.TaskAction


const val LIST_SCREEN = "list/{action}"
const val LIST_SCREEN_ACTION = "action"
const val TASK_SCREEN = "task/{taskId}"
const val TASK_SCREEN_ID = "taskId"
class Screens(navHostController: NavHostController) {
    val list: (TaskAction) -> Unit = { action ->
        navHostController.navigate("list/${action.name}"){
            popUpTo(LIST_SCREEN) {inclusive = true}
        }
    }

    val task: (Long) -> Unit = {taskId ->
        navHostController.navigate("task/$taskId")
    }
}