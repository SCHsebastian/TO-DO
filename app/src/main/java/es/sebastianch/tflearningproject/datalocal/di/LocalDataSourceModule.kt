package es.sebastianch.tflearningproject.datalocal.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.sebastianch.tflearningproject.datalocal.source.task.TaskLocalDataSourceImpl
import es.sebastianch.tflearningproject.datarepository.task.datasource.TaskLocalDataSource

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindTaskDataSource(taskLocalDataSourceImpl: TaskLocalDataSourceImpl): TaskLocalDataSource

}
