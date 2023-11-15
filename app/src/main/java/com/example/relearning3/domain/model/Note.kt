package com.example.relearning3.domain.model

data class Note(
    val id: Int,
    val title: String,
    val body: String,
    val date: String,
    val primaryTags: List<String>,
    val secondaryTags: List<String>
)
