package es.sebastianch.tflearningproject.domain.features.task.usecase

import es.sebastianch.tflearningproject.domain.common.UseCase
import es.sebastianch.tflearningproject.domain.features.task.model.Task
import es.sebastianch.tflearningproject.domain.features.task.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SaveTaskUseCase (
    configuration: Configuration,
    private val taskRepository: TaskRepository
): UseCase<SaveTaskUseCase.Request, SaveTaskUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> {
        taskRepository.upsertTask(request.task)
        return flowOf(Response)
    }

    data class Request(val task: Task): UseCase.Request
    data object Response: UseCase.Response
}