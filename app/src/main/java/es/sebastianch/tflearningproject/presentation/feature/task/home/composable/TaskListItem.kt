package es.sebastianch.tflearningproject.presentation.feature.task.home.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.sebastianch.tflearningproject.common.types.PriorityType
import es.sebastianch.tflearningproject.presentation.common.compose.items.PrioritySimpleItem

/*
* +----------------------------+
|  Title: Buy groceries       |
|  Description: Milk, bread, |
|   eggs, cereal.             |
|  Priority: High            |
|  Due: Today, 5:00 PM        |
|  [ ] Checkbox               |
|  #grocery                 |
+----------------------------+
* */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListItem(
    title: String,
    description: String,
    priorityType: PriorityType
) {
    var isCompleted by remember { mutableStateOf(false) }
    var isExpanded by remember { mutableStateOf(false) }
    val enterTransition = remember {
        expandVertically (
            expandFrom = Alignment.Top,
            animationSpec = tween(300)
        ) + fadeIn(
            initialAlpha = .3f,
            animationSpec = tween()
        )
    }
    val exitTransition = remember {
        shrinkVertically (
            shrinkTowards = Alignment.Top,
            animationSpec = tween()
        ) + fadeOut(tween())
    }

    Card(
        modifier = Modifier
            .background(color = Color.LightGray, shape = RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp)),
        onClick = { isExpanded = !isExpanded }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier.weight(1f, true),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = title, maxLines = 2, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    PrioritySimpleItem(priorityType = priorityType)
                }
                Checkbox(
                    checked = isCompleted,
                    onCheckedChange = { isCompleted = !isCompleted }
                )
            }
            AnimatedVisibility(
                visible = isExpanded,
                enter = enterTransition,
                exit = exitTransition
            ) {
                Spacer(modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth())
                Text(
                    text = description
                )
            }
        }
    }
}

@Preview
@Composable
fun prev(){
    Scaffold (modifier = Modifier.padding(10.dp)){
        it.calculateBottomPadding()
        TaskListItem(
            title = "Título",
            description = "Descripción es súper chulo porque Mari lo dice..." +
                    "Descripción es súper chulo porque Mari lo dice..." +
                    "Descripción es súper chulo porque Mari lo dice..." +
                    "Descripción es súper chulo porque Mari lo dice..." +
                    "Descripción es súper chulo porque Mari lo dice..." +
                    "Descripción es súper chulo porque Mari lo dice..." +
                    "Descripción es súper chulo porque Mari lo dice..." +
                    "Descripción es súper chulo porque Mari lo dice...",
            priorityType = PriorityType.LOW
        )
    }

}