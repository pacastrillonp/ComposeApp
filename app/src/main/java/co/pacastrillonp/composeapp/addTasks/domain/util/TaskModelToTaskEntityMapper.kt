package co.pacastrillonp.composeapp.addTasks.domain.util

import co.pacastrillonp.composeapp.addTasks.data.entities.TaskEntity
import co.pacastrillonp.composeapp.addTasks.ui.model.TaskModel

fun TaskModel.taskModelToTaskEntityMapper(): TaskEntity = TaskEntity(id, task, selected)