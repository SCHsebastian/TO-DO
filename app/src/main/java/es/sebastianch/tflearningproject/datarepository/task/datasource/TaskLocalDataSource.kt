package es.sebastianch.tflearningproject.datarepository.task.datasource

import es.sebastianch.tflearningproject.domain.features.task.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskLocalDataSource {
    fun getAllTask(): Flow<List<Task>>

    fun getTask(id: Int): Flow<Task>

    suspend fun deleteTask(task: Task)

    suspend fun upsertTask(task: Task)
}