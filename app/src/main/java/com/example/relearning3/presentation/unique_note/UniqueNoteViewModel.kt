package com.example.relearning3.presentation.unique_note

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.relearning3.data.mapper.toList
import com.example.relearning3.domain.model.Note
import com.example.relearning3.domain.repository.NotesRepository
import com.example.relearning3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniqueNoteViewModel @Inject constructor(
    private val notesRepository: NotesRepository,
    private val app: Application,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var state by mutableStateOf(UniqueNoteState())

    init {
        viewModelScope.launch {
            val id = savedStateHandle.get<Int>("id") ?: return@launch
            if (id > -1)
                notesRepository.getNote(id).collect() {
                    when (it) {
                        is Resource.Success -> {
                            state = state.copy(note = it.data!!)
                        }

                        is Resource.Error -> {
                            it.message?.let { message ->
                                Toast.makeText(app, message, Toast.LENGTH_LONG).show()
                            }
                        }

                        is Resource.Loading -> {
                            state = state.copy(isLoading = it.isLoading)
                        }
                    }
                }
            else
                state = state.copy(isLoading = false)
        }
    }

    fun onNoteChange(event: UniqueScreenEvent) {
        val currentNote = state.note
        state = when(event) {
            is UniqueScreenEvent.Title -> {
                state.copy(note = currentNote.copy(title = event.data))
            }

            is UniqueScreenEvent.Body -> {
                state.copy(note = currentNote.copy(body = event.data))
            }

            is UniqueScreenEvent.pTag -> {
                state.copy(note = currentNote.copy(primaryTags = event.data.toList()))
            }

            is UniqueScreenEvent.sTag -> {
                state.copy(note = currentNote.copy(secondaryTags = event.data.toList()))
            }
        }
    }

    fun saveNote(note: Note = state.note!!) = viewModelScope.launch { notesRepository.addNote(note) }
    fun deleteNote(note: Note = state.note!!) = viewModelScope.launch { notesRepository.deleteNote(note) }
}