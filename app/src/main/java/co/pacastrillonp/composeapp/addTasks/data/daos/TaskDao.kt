package co.pacastrillonp.composeapp.addTasks.data.daos

import androidx.room.Insert
import androidx.room.Query
import co.pacastrillonp.composeapp.addTasks.data.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskDao {

    @Query("SELECT * FROM ${TaskEntity.TABLE_NAME}")
    fun getTask(): Flow<List<TaskEntity>>

    @Insert
    suspend fun addTask(taskEntity: TaskEntity)

}