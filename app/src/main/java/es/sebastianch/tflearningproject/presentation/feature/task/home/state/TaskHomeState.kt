package es.sebastianch.tflearningproject.presentation.feature.task.home.state

import es.sebastianch.tflearningproject.presentation.common.utils.Empty

data class TaskHomeState (
    val message: String = String.Empty,
    val showMessage: Boolean = false
){

}