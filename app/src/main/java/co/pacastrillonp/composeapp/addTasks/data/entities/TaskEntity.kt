package co.pacastrillonp.composeapp.addTasks.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TaskEntity.TABLE_NAME)
data class TaskEntity(
    @PrimaryKey val id: Long,
    val task: String,
    var selected: Boolean
) {
    companion object {
        const val TABLE_NAME = "task_entity_table"
    }
}