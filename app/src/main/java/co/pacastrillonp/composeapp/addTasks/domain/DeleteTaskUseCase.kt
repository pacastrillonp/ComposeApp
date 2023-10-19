package co.pacastrillonp.composeapp.addTasks.domain

import co.pacastrillonp.composeapp.addTasks.data.TaskRepository
import co.pacastrillonp.composeapp.addTasks.ui.model.TaskModel
import javax.inject.Inject

class DeleteTaskUseCase  @Inject constructor(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(taskModel: TaskModel){
        taskRepository.delete(taskModel)
    }
}