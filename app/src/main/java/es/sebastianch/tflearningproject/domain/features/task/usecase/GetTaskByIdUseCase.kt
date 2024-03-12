package es.sebastianch.tflearningproject.domain.features.task.usecase

import es.sebastianch.tflearningproject.domain.common.UseCase
import es.sebastianch.tflearningproject.domain.features.task.model.Task
import es.sebastianch.tflearningproject.domain.features.task.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTaskByIdUseCase(
    configuration: Configuration,
    private val taskRepository: TaskRepository
): UseCase<GetTaskByIdUseCase.Request, GetTaskByIdUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        taskRepository.getTask(request.taskId).map {
            Response(it)
        }


    data class Request(val taskId: Long): UseCase.Request
    data class Response(val task: Task): UseCase.Response
}