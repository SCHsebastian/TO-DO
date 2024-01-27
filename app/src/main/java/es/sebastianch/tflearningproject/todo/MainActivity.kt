package es.sebastianch.tflearningproject.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import es.sebastianch.tflearningproject.presentation.common.navigation.NavRoutes
import es.sebastianch.tflearningproject.presentation.feature.task.home.TaskHomeViewModel
import es.sebastianch.tflearningproject.presentation.feature.task.home.composable.InitScreen
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.InitUserEvents
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.TaskHomeState
import es.sebastianch.tflearningproject.todo.ui.theme.TFLearningProjectTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    private val viewModel: TaskHomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TFLearningProjectTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    App(navController)
                }
            }
        }
    }

    @Composable
    fun App(navController: NavHostController) {
        NavHost(navController = navController, startDestination = NavRoutes.Task.Home.route){
            composable(NavRoutes.Task.Home.route){
                LoadScreen(
                    state = viewModel.screenState,
                    onEvent = viewModel::onEvent
                )
            }

        }
    }


    @Composable
    fun LoadScreen(state: State<TaskHomeState>, onEvent: (InitUserEvents) -> Unit) =
        InitScreen(state = state.value, onEvent = onEvent)



}