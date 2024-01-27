package es.sebastianch.tflearningproject.todo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.sebastianch.tflearningproject.datarepository.task.TaskRepositoryImpl
import es.sebastianch.tflearningproject.datarepository.task.datasource.TaskLocalDataSource
import es.sebastianch.tflearningproject.domain.features.task.repository.TaskRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesTaskRepository(
        localDataSource: TaskLocalDataSource
    ): TaskRepository = TaskRepositoryImpl(localDataSource)

}