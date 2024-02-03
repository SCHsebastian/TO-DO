package es.sebastianch.tflearningproject.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import es.sebastianch.tflearningproject.presentation.common.navigation.SetupNavigation
import es.sebastianch.tflearningproject.todo.ui.theme.TFLearningProjectTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TFLearningProjectTheme {
                navHostController = rememberNavController()
                SetupNavigation(navHostController = navHostController)
            }
        }
    }
}