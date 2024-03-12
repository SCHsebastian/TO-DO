package es.sebastianch.tflearningproject.datalocal.source.task

import es.sebastianch.tflearningproject.datalocal.db.task.TaskDao
import es.sebastianch.tflearningproject.datalocal.db.task.toDomain
import es.sebastianch.tflearningproject.datalocal.db.task.toEntity
import es.sebastianch.tflearningproject.datarepository.task.datasource.TaskLocalDataSource
import es.sebastianch.tflearningproject.domain.features.task.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskLocalDataSourceImpl @Inject constructor(
    private val taskDao: TaskDao
): TaskLocalDataSource {

    override fun getAllTask(): Flow<List<Task>> = taskDao.getAllTask().map { tasks ->
        tasks.map {
            it.toDomain()
        }
    }

    override fun getTask(id: Long): Flow<Task> = taskDao.getTask(id).map { it.toDomain() }

    override fun deleteTask(task: Task) = flow {
        taskDao.deleteTask(task.toEntity())
        emit(true)
    }

    override fun upsertTask(task: Task) = flow {
        emit(taskDao.upsertTask(task.toEntity()))
    }

}