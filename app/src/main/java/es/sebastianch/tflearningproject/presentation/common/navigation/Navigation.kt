package es.sebastianch.tflearningproject.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import es.sebastianch.tflearningproject.presentation.common.navigation.task.taskComposable
import es.sebastianch.tflearningproject.presentation.common.navigation.task.tasksHomeComposable

@Composable
fun SetupNavigation(
    navHostController: NavHostController
) {
    val screen = remember(navHostController){
        Screens(navHostController = navHostController)
    }

    NavHost(
        navController = navHostController,
        startDestination = LIST_SCREEN
    ){
        tasksHomeComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}