package es.sebastianch.tflearningproject.presentation.feature.task.home.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import es.sebastianch.tflearningproject.R
import es.sebastianch.tflearningproject.todo.ui.theme.TFLearningProjectTheme
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.TaskHomeState
import es.sebastianch.tflearningproject.presentation.feature.task.home.state.InitUserEvents

@Composable
fun InitScreen(
    state: TaskHomeState,
    onEvent: (InitUserEvents) -> Unit = {}
) {
    TFLearningProjectTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting(
                onSendMessageClick = { onEvent(InitUserEvents.OnSendMessageClicked) },
                onTextEdited = { onEvent(InitUserEvents.OnMessageTextChanged(it))},
                onCloseDialog = { onEvent(InitUserEvents.OnCloseDialogClicked)},
                state = state
            )
        }
    }
}

@Composable
fun ShowDialog(state: TaskHomeState, onCloseDialog:()-> Unit) {
    if (state.showMessage){
        AlertDialog(
            onDismissRequest = {onCloseDialog.invoke()},
            text = { Text(text = state.message) },
            dismissButton = {
                Button(
                    onClick = { onCloseDialog.invoke() }
                ) {
                    Text(text = stringResource(id = R.string.close))
                }
            },
            confirmButton = {
                Button(
                    onClick = { onCloseDialog.invoke() }
                ) {
                    Text(text = stringResource(id = R.string.accept))
                }
            }
        )
    }
}

@Composable
fun Greeting(onSendMessageClick: () -> Unit, onTextEdited: (String) -> Unit, onCloseDialog:()->Unit,state: TaskHomeState) {
    Box(modifier = Modifier.fillMaxSize()){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Row {
                TextField(
                    value = state.message,
                    onValueChange = { newText ->
                        onTextEdited(newText)
                    }
                )
                Button(onClick = { onSendMessageClick.invoke() }) {
                    Text(text = "Send Message")
                }
            }
        }
    }
    ShowDialog(state, onCloseDialog = onCloseDialog)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TFLearningProjectTheme {
        Greeting({},{},{}, state = TaskHomeState())
    }
}