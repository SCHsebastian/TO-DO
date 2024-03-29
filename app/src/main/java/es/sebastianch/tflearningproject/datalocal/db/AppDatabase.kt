package es.sebastianch.tflearningproject.datalocal.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import es.sebastianch.tflearningproject.datalocal.db.task.Converters
import es.sebastianch.tflearningproject.datalocal.db.task.TaskDao
import es.sebastianch.tflearningproject.datalocal.db.task.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object{
        const val DATABASE_NAME = "TO-DO_Database"
    }
}