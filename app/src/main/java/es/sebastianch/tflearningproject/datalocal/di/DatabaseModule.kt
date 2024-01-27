package es.sebastianch.tflearningproject.datalocal.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.sebastianch.tflearningproject.datalocal.db.AppDatabase
import es.sebastianch.tflearningproject.datalocal.db.AppDatabase.Companion.DATABASE_NAME

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    fun providesToDoDao(
        roomDatabase: AppDatabase
    ) = roomDatabase.taskDao()
}