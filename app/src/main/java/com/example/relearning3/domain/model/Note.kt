package com.example.relearning3.domain.model

data class Note(
    val id: Int? = null,
    val title: String = "",
    val body: String = "",
    val date: String = "",
    val primaryTags: List<String> = emptyList(),
    val secondaryTags: List<String> = emptyList()
)
