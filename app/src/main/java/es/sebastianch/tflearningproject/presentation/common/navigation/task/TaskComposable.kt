package es.sebastianch.tflearningproject.presentation.common.navigation.task

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import es.sebastianch.tflearningproject.presentation.common.navigation.TASK_SCREEN
import es.sebastianch.tflearningproject.presentation.common.navigation.TASK_SCREEN_ID
import es.sebastianch.tflearningproject.presentation.feature.task.item.TaskEditScreen

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (TaskAction) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_SCREEN_ID){
            type = NavType.LongType
        })
    ){
        TaskEditScreen(taskId = it.arguments!!.getLong(TASK_SCREEN_ID, -1), backNavigation = navigateToListScreen)
    }
}
