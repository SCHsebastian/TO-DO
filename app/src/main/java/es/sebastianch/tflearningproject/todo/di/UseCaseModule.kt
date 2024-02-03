package es.sebastianch.tflearningproject.todo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.sebastianch.tflearningproject.domain.common.UseCase
import es.sebastianch.tflearningproject.domain.features.task.repository.TaskRepository
import es.sebastianch.tflearningproject.domain.features.task.usecase.GetAllTaskUseCase
import es.sebastianch.tflearningproject.domain.features.task.usecase.GetTaskListByPriority
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCaseConfiguration() =
        UseCase.Configuration(Dispatchers.IO)

    @Provides
    fun provideGetAllTaskUseCase(
        configuration: UseCase.Configuration,
        repository: TaskRepository
    ) = GetAllTaskUseCase(configuration, repository)

    @Provides
    fun providesGetTaskListByPriority(
        configuration: UseCase.Configuration,
        repository: TaskRepository
    ) = GetTaskListByPriority(configuration, repository)

}