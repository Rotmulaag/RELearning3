package com.example.relearning3.domain.repository

import com.example.relearning3.domain.model.Note
import com.example.relearning3.util.Resource
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    suspend fun addNote(note: Note)
    suspend fun editNote(note: Note)
    suspend fun deleteNote(note: Note)

    suspend fun getNote(id: Int): Flow<Resource<Note>>
    suspend fun getNotes(query: String): Flow<Resource<List<Note>>>
    //suspend fun searchNotes(query: String): Flow<Resource<List<Note>>>

}