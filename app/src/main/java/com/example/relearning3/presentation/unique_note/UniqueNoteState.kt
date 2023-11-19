package com.example.relearning3.presentation.unique_note

import com.example.relearning3.domain.model.Note

data class UniqueNoteState(
    val isLoading: Boolean = true,
    val note: Note? = null
)