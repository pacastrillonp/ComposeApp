package co.pacastrillonp.composeapp.addTasks.data

import androidx.room.Database
import androidx.room.RoomDatabase
import co.pacastrillonp.composeapp.addTasks.data.daos.TaskDao
import co.pacastrillonp.composeapp.addTasks.data.entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

}