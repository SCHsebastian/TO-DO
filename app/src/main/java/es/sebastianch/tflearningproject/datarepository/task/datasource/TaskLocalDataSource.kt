package es.sebastianch.tflearningproject.datarepository.task.datasource

import es.sebastianch.tflearningproject.domain.features.task.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskLocalDataSource {
    fun getAllTask(): Flow<List<Task>>

    fun getTask(id: Long): Flow<Task>

    fun deleteTask(task: Task): Flow<Boolean>

    fun upsertTask(task: Task): Flow<Long>
}