package es.sebastianch.tflearningproject.domain.features.task.repository

import es.sebastianch.tflearningproject.domain.features.task.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getAllTask(): Flow<List<Task>>
    fun getTask(id: Long): Flow<Task>
    fun deleteTask(task: Task)
    fun upsertTask(task: Task)

}