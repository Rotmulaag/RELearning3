package com.example.relearning3.data.repository

import com.example.relearning3.data.local.NotesDatabase
import com.example.relearning3.data.mapper.toNote
import com.example.relearning3.data.mapper.toNoteEntity
import com.example.relearning3.domain.model.Note
import com.example.relearning3.domain.repository.NotesRepository
import com.example.relearning3.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotesRepositoryImpl @Inject constructor(private val db: NotesDatabase): NotesRepository {

    private val dao = db.dao

    override suspend fun addNote(note: Note) = dao.addNote(note.toNoteEntity())

    override suspend fun editNote(note: Note) = dao.addNote(note.toNoteEntity())

    override suspend fun deleteNote(note: Note) = dao.deleteNote(note.toNoteEntity())

    override suspend fun getNote(id: Int): Flow<Resource<Note>> = flow {
        emit(Resource.Loading())
        emit(Resource.Success(dao.getNote(id).toNote()))
        emit(Resource.Loading(false))
    }

    override suspend fun getNotes(query: String): Flow<Resource<List<Note>>> = flow {
        emit(Resource.Loading())
        emit(Resource.Success(dao.searchNotes(query).map { it.toNote() }))
        emit(Resource.Loading(false))
    }
}