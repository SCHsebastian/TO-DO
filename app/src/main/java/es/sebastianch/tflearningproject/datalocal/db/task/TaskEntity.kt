package es.sebastianch.tflearningproject.datalocal.db.task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import es.sebastianch.tflearningproject.domain.features.task.model.Priority
import es.sebastianch.tflearningproject.domain.features.task.model.Task


@Entity(tableName = "task")
data class TaskEntity (
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "priority") val priority: PriorityEntity
)

fun TaskEntity.toDomain() = Task(
    id = id,
    title = title,
    description = description,
    priority = Priority.valueOf(priority.name)
)

fun Task.toEntity() = TaskEntity(
    id = id,
    title = title,
    description = description,
    priority = PriorityEntity.valueOf(priority.name)
)