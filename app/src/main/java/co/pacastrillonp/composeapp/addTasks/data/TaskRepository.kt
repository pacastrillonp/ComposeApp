package co.pacastrillonp.composeapp.addTasks.data

import co.pacastrillonp.composeapp.addTasks.data.daos.TaskDao
import co.pacastrillonp.composeapp.addTasks.data.entities.TaskEntity
import co.pacastrillonp.composeapp.addTasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    val tasks: Flow<List<TaskModel>> = taskDao.getTask().map {
        it.map { entity -> TaskModel(entity.id, entity.task, entity.selected) }
    }

    suspend fun add(taskModel: TaskModel) {
        val taskEntity = TaskEntity(taskModel.id, taskModel.task, taskModel.selected)
        taskDao.addTask(taskEntity)
    }
}