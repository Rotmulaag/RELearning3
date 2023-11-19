package com.example.relearning3.presentation.home_screen

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.relearning3.domain.model.Note
import com.example.relearning3.domain.repository.NotesRepository
import com.example.relearning3.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: NotesRepository,
    private val app: Application): ViewModel() {

    var state by mutableStateOf(HomeScreenState())

    private var searchJob: Job? = null

    init { getNotes() }

    fun onSeachQueryChange(query: String) {
        state = state.copy(query = query)
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            getNotes()
        }
    }

    private fun getNotes(query: String = state.query.lowercase()) = viewModelScope.launch {
        repository.getNotes(query).collect {
            when(it) {
                is Resource.Success -> {
                    it.data?.let { notes: List<Note> -> state = state.copy(notes = notes) }
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
    }
}