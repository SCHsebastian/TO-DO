package es.sebastianch.tflearningproject.datalocal.db.task

import androidx.room.Entity

@Entity(tableName = "Priority")
enum class PriorityEntity{
    HIGH,
    MEDIUM,
    LOW,
    NONE;
}