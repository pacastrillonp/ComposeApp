package co.pacastrillonp.composeapp.addTasks.ui

import co.pacastrillonp.composeapp.addTasks.ui.model.TaskModel

sealed interface TaskUiState {
    object Loading : TaskUiState
    data class Error(val throwable: Throwable) : TaskUiState
    data class Success(val tasks: List<TaskModel>) : TaskUiState
}