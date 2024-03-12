package es.sebastianch.tflearningproject.datalocal.db.task

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun toPriority(value: String) = enumValueOf<PriorityEntity>(value)

    @TypeConverter
    fun fromPriority(value: PriorityEntity) = value.name

}