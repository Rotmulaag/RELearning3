package com.example.relearning3.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.relearning3.data.local.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotesDatabase(app: Application): NotesDatabase = Room.databaseBuilder(
        app,
        NotesDatabase::class.java,
        "notes.db"
    ).build()
}