package com.example.relearning3.data.local

import androidx.room.Database
import com.example.relearning3.data.local.dao.NoteDao
import com.example.relearning3.data.local.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NotesDatabase {
    abstract val dao: NoteDao
}