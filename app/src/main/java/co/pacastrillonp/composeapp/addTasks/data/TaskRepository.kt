package co.pacastrillonp.composeapp.addTasks.data

import co.pacastrillonp.composeapp.addTasks.data.daos.TaskDao
import co.pacastrillonp.composeapp.addTasks.data.entities.TaskEntity
import co.pacastrillonp.composeapp.addTasks.domain.util.taskModelToTaskEntityMapper
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
        taskDao.addTask(taskModel.taskModelToTaskEntityMapper())
    }

    suspend fun update(taskModel: TaskModel) {
        taskDao.updateTask(taskModel.taskModelToTaskEntityMapper())
    }

    suspend fun delete(taskModel: TaskModel) {
        taskDao.deleteTask(taskModel.taskModelToTaskEntityMapper())
    }
}