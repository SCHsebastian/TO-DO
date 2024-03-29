package es.sebastianch.tflearningproject.presentation.feature.task.vo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.sebastianch.tflearningproject.R

@Composable
fun PriorityItem(priorityType: PriorityVO) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Canvas(modifier = Modifier.size(16.dp)){
            drawCircle(color = priorityType.color)
        }
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = stringResource(id = priorityType.title))
    }
}

@Composable
fun PrioritySimpleItem(priorityType: PriorityVO) {
    Canvas(modifier = Modifier.size(16.dp)){
        drawCircle(color = priorityType.color)
    }
}

@Composable
fun PriorityTypeDropDownMenu(
    priorityTypeList: List<PriorityVO>,
    onItemAction: (PriorityVO) -> Unit,
){
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
            priorityTypeList.forEach{
                DropdownMenuItem(
                    text = { PriorityItem(it) },
                    onClick = { onItemAction.invoke(it) })
            }
        }
    }
}

@Preview
@Composable
fun prev(){
    val priorityVO = PriorityVO(0, Color.Yellow)

    Column(
        modifier = Modifier.background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PriorityItem(priorityType = priorityVO)
        Spacer(modifier = Modifier.height(16.dp))
        PrioritySimpleItem(priorityType = priorityVO)
    }
}