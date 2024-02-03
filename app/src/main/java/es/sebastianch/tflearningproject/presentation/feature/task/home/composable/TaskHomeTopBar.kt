package es.sebastianch.tflearningproject.presentation.feature.task.home.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import es.sebastianch.tflearningproject.R
import es.sebastianch.tflearningproject.common.types.PriorityType
import es.sebastianch.tflearningproject.presentation.common.compose.items.PriorityItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskHomeTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.task_list))
        },
        actions = {
            TaskSearch {}
            SortItem {}
        }
    )
}

@Composable
fun TaskSearch(
    onSearchClicked: () -> Unit
) {
    IconButton(onClick = onSearchClicked) {
        Icon(
            imageVector = Icons.Sharp.Search,
            contentDescription = stringResource(id = R.string.search_item)
        )
    }
}

@Composable
fun SortItem(
    onSortAction: () -> Unit
) {
    var expanded by remember{ mutableStateOf(false) }

    IconButton(onClick ={ expanded = true}) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_filter_list),
            contentDescription = stringResource(id = R.string.sort_item)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = {
                    PriorityItem(priorityType = PriorityType.LOW)
                       },
                onClick = {
                    expanded = false
                    onSortAction.invoke()
                }
            )
        }
    }
}
