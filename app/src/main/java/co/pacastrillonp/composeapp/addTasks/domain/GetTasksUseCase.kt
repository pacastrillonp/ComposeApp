package co.pacastrillonp.composeapp.addTasks.domain

import co.pacastrillonp.composeapp.addTasks.data.TaskRepository
import co.pacastrillonp.composeapp.addTasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val taskRepository: TaskRepository) {

    operator fun invoke(): Flow<List<TaskModel>> = taskRepository.tasks
}