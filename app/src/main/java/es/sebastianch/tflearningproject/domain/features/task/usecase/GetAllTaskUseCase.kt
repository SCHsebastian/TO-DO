package es.sebastianch.tflearningproject.domain.features.task.usecase

import es.sebastianch.tflearningproject.domain.common.UseCase
import es.sebastianch.tflearningproject.domain.features.task.model.Task
import es.sebastianch.tflearningproject.domain.features.task.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllTaskUseCase(
    configuration: Configuration,
    private val taskRepository: TaskRepository
): UseCase<GetAllTaskUseCase.Request, GetAllTaskUseCase.Response>(configuration){

    override fun process(request: Request): Flow<Response> {
        return taskRepository.getAllTask().map {
            Response(taskList = it)
        }
    }

    object Request : UseCase.Request
    data class Response(val taskList: List<Task>) : UseCase.Response
}