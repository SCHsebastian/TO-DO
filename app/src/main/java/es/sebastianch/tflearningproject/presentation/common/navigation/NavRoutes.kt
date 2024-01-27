package es.sebastianch.tflearningproject.presentation.common.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import es.sebastianch.tflearningproject.presentation.common.navigation.task.TaskAction
import es.sebastianch.tflearningproject.presentation.common.navigation.task.TaskInput

private const val ROUTE_TASK_HOME = "task/home"
private const val ROUTE_TASK_ITEM = "task/"

private const val ARG_TASK_ITEM = "itemId"
private const val ARG_TASK_ACTION = "action"

sealed class NavRoutes (
    val route: String,
    val args: List<NamedNavArgument> = emptyList()
){

    sealed class Task(route: String, args: List<NamedNavArgument> = emptyList()) : NavRoutes(route, args) {
        data object Home : Task(route = String.format(ROUTE_TASK_HOME))
        data object Item : Task(
            route = String.format(
                format = ROUTE_TASK_ITEM,
                args = arrayOf(ARG_TASK_ITEM, ARG_TASK_ACTION)),
            args = listOf(
                navArgument(ARG_TASK_ITEM) { type = NavType.LongType},
                navArgument(ARG_TASK_ACTION) { type = NavType.EnumType(type = TaskAction::class.java)}
        ) ){
            fun routeForTask(taskInput: TaskInput) = String.format(ROUTE_TASK_ITEM, taskInput.taskId, taskInput.taskAction)
        }
    }

}