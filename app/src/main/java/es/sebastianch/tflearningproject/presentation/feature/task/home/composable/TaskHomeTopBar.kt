package es.sebastianch.tflearningproject.presentation.feature.task.home.composable

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import es.sebastianch.tflearningproject.R
import es.sebastianch.tflearningproject.common.types.PriorityType
import es.sebastianch.tflearningproject.presentation.common.compose.items.PriorityTypeDropDownMenu
import es.sebastianch.tflearningproject.presentation.common.compose.search.SearchIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskHomeTopBar(
    onQueryChange: (String)-> Unit,
    onSearch: (String)-> Unit
) {
    val priorityTypeList = listOf(
        PriorityType.HIGH,
        PriorityType.MEDIUM,
        PriorityType.LOW,
        PriorityType.NONE
    )

    var isSearching by remember { mutableStateOf(false) }

    if (!isSearching) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = stringResource(id = R.string.task_list))
            },
            actions = {
                SearchIconButton { isSearching = true }
                PriorityTypeDropDownMenu(priorityTypeList,{})
            }
        )
    }else {
        var query by remember { mutableStateOf("") }
        SearchBar(
            query = query,
            onQueryChange = {query = it},
            onSearch = onSearch,
            active = true,
            onActiveChange = {isSearching = it},
        ) {

        }
    }
}
