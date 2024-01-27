package es.sebastianch.tflearningproject.datarepository.task

import es.sebastianch.tflearningproject.datarepository.task.datasource.TaskLocalDataSource
import es.sebastianch.tflearningproject.domain.features.task.model.Task
import es.sebastianch.tflearningproject.domain.features.task.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val taskLocalDataSource: TaskLocalDataSource,
    //val taskRemoteDataSource: TaskRemoteDataSource
): TaskRepository {

    override fun getAllTask(): Flow<List<Task>> = taskLocalDataSource.getAllTask()

    override fun getTask(id: Int): Flow<Task> = taskLocalDataSource.getTask(id)


    override suspend fun deleteTask(task: Task) {
        taskLocalDataSource.deleteTask(task)
    }

    override suspend fun insertTask(task: Task){
        taskLocalDataSource.upsertTask(task)
    }

    override suspend fun updateTask(task: Task){
        taskLocalDataSource.upsertTask(task)
    }

}