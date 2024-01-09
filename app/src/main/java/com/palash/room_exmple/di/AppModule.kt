package com.palash.room_exmple.di

import android.content.Context
import androidx.room.Room
import com.palash.room_exmple.api_service.MyDao
import com.palash.room_exmple.room_db.AppDatabase
import com.palash.room_exmple.room_db.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "wass")
            .fallbackToDestructiveMigration()
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    @Provides
    fun provideDao(appDatabase: AppDatabase) : MyDao = appDatabase.myDaoFromAppDatabase()
}