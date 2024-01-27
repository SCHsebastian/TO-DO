package es.sebastianch.tflearningproject.domain.features.task.repository

import es.sebastianch.tflearningproject.domain.features.task.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getAllTask(): Flow<List<Task>>
    fun getTask(id: Int): Flow<Task>
    suspend fun deleteTask(task: Task)
    suspend fun insertTask(task: Task)
    suspend fun updateTask(task: Task)

}