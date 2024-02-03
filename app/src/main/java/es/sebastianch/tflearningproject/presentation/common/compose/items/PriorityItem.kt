package es.sebastianch.tflearningproject.presentation.common.compose.items

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.sebastianch.tflearningproject.common.types.PriorityType

@Composable
fun PriorityItem(priorityType: PriorityType) {

    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Canvas(modifier = Modifier.size(16.dp)){
            drawCircle(color = priorityType.color)
        }
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = priorityType.name)
    }
}

@Preview
@Composable
fun prev(){
    PriorityItem(priorityType = PriorityType.MEDIUM)
}