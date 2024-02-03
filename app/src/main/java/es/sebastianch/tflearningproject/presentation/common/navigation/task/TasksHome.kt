package es.sebastianch.tflearningproject.presentation.common.navigation.task

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import es.sebastianch.tflearningproject.presentation.common.navigation.LIST_SCREEN
import es.sebastianch.tflearningproject.presentation.common.navigation.LIST_SCREEN_ACTION
import es.sebastianch.tflearningproject.presentation.feature.task.home.composable.TaskHomeScreen

fun NavGraphBuilder.tasksHomeComposable(
    navigateToTaskScreen: (Long) -> Unit
){
    composable(
       route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_SCREEN_ACTION){
            type = NavType.StringType
        })
    ){
        TaskHomeScreen(viewModel = hiltViewModel(), navigateToTaskScreen = navigateToTaskScreen)
    }
}