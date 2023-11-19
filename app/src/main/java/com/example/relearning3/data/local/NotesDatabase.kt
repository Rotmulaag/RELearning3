package com.example.relearning3.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.relearning3.data.local.dao.NoteDao
import com.example.relearning3.data.local.entity.NoteEntity


@Database(entities = [NoteEntity::class], version = 1)
abstract class NotesDatabase: RoomDatabase() {
    abstract val dao: NoteDao
}