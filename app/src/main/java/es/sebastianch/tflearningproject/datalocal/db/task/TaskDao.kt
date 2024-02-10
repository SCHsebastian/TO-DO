package es.sebastianch.tflearningproject.datalocal.db.task

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAllTask(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM task WHERE id = :id")
    fun getTask(id: Int): Flow<TaskEntity>

    @Delete
    suspend fun deleteTask(task: TaskEntity)

    @Upsert
    suspend fun upsertTask(task: TaskEntity): Long

}