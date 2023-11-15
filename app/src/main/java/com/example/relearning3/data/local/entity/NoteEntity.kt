package com.example.relearning3.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val body: String,
    val date: String,
    val primaryTags: String,
    val secondaryTags: String
)
