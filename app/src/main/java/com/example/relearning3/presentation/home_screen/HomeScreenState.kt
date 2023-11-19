package com.example.relearning3.presentation.home_screen

import com.example.relearning3.domain.model.Note

data class HomeScreenState(
    val isLoading: Boolean = false,
    val notes: List<Note> = emptyList(),
    val query: String = ""
)