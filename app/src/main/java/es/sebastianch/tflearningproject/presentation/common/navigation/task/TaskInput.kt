package es.sebastianch.tflearningproject.presentation.common.navigation.task

data class TaskInput (val taskId: Long, val taskAction: TaskAction = TaskAction.NONE)

enum class TaskAction{
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    NONE;
}