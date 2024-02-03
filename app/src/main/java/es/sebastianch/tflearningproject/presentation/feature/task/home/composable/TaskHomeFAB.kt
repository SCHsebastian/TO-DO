package es.sebastianch.tflearningproject.presentation.feature.task.home.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import es.sebastianch.tflearningproject.R

@Composable
fun TaskHomeFAB(onFABClick: () -> Unit){
    FloatingActionButton(
        onClick = { onFABClick.invoke() }
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = stringResource(id = R.string.add_task_button))
    }
}