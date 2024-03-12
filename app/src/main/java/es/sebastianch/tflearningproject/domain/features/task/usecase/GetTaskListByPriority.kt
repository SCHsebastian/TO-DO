package es.sebastianch.tflearningproject.domain.features.task.usecase

import es.sebastianch.tflearningproject.domain.common.UseCase
import es.sebastianch.tflearningproject.domain.features.task.model.Priority
import es.sebastianch.tflearningproject.domain.features.task.model.Task
import es.sebastianch.tflearningproject.domain.features.task.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTaskListByPriority(
    configuration: Configuration,
    private val taskRepository: TaskRepository
): UseCase<GetTaskListByPriority.Request, GetTaskListByPriority.Response>(configuration){

    override fun process(request: Request): Flow<Response> {
        return taskRepository.getAllTask().map { taskList ->
            Response(taskList.takeWhile { it.priority == request.priority })
        }
    }

    data class Request(val priority: Priority) : UseCase.Request
    data class Response(val taskList: List<Task>) : UseCase.Response
}