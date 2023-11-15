package com.example.relearning3.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.relearning3.data.local.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: List<NoteEntity>)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM Notes")
    suspend fun getNotes(): List<NoteEntity>

    @Query("SELECT * FROM Notes WHERE id = :id")
    suspend fun getNote(id: Int): NoteEntity

    @Query("""
        SELECT * FROM Notes WHERE
        LOWER(title) LIKE "%" || LOWER(:query) || "%" AND
        LOWER(primaryTags) LIKE "%" || LOWER(:query) || "%" AND
        LOWER(secondaryTags) LIKE "%" || LOWER(:query) || "%" 
    """) //should return results from every WHERE (but it probs doesn't)
    suspend fun searchNotes(query: String): List<NoteEntity> //Title, pTag, sTag
}