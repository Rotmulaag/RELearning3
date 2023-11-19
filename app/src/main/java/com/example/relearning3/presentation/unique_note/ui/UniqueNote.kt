package com.example.relearning3.presentation.unique_note.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.relearning3.presentation.unique_note.UniqueNoteViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun UniqueNote(
    id: Int,
    viewModel: UniqueNoteViewModel = hiltViewModel()
) {
}