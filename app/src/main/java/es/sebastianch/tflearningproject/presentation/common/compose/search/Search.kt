package es.sebastianch.tflearningproject.presentation.common.compose.search

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import es.sebastianch.tflearningproject.R

@Composable
fun SearchIconButton(onSeachPressed: ()-> Unit) {
    IconButton(onClick = onSeachPressed) {
        Icon(
            imageVector = Icons.Sharp.Search,
            contentDescription = stringResource(id = R.string.search_item)
        )
    }
}