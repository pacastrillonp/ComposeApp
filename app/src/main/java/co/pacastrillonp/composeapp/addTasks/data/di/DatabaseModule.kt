package co.pacastrillonp.composeapp.addTasks.data.di

import android.content.Context
import androidx.room.Room
import co.pacastrillonp.composeapp.addTasks.data.ToDoDatabase
import co.pacastrillonp.composeapp.addTasks.data.daos.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun todoDatabase(@ApplicationContext appContext: Context): ToDoDatabase {
        return Room.databaseBuilder(
            context = appContext,
            klass = ToDoDatabase::class.java,
            name = "ToDoDatabase.db"
        ).build()
    }

    @Provides
    fun taskDaoProvider(toDoDatabase : ToDoDatabase): TaskDao
        = toDoDatabase.taskDao()

}