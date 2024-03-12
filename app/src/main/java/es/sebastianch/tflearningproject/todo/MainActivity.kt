package es.sebastianch.tflearningproject.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import es.sebastianch.tflearningproject.todo.ui.theme.TFLearningProjectTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TFLearningProjectTheme {
                navController = rememberNavController()
                navController.navigate(
                    NavDeepLinkRequest.Builder.fromUri("".toUri()).build()
                )
            }
        }
    }
}