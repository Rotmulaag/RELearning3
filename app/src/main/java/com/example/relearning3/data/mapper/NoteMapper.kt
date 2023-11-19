package com.example.relearning3.data.mapper

import com.example.relearning3.data.local.entity.NoteEntity
import com.example.relearning3.domain.model.Note

fun String.toList(): List<String> {
    val list = emptyList<String>().toMutableList()
    var word = ""

    var prev = ' '
    for (c in this) {
        if (c == '[' || c == ']' || c == ' ' && prev == ','/* || c == ',' && prev == ' '*/) continue
        if (c != ',')
            word += c
        else {
            list.add(word)
            word = ""
        }
        prev = c
    }
    list.add(word)

    return list
}

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        body = body,
        date = date,
        primaryTags = primaryTags.toList(),
        secondaryTags = secondaryTags.toList()
    )
}

fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        title = title,
        body = body,
        date = date,
        primaryTags = primaryTags.toString(),
        secondaryTags = secondaryTags.toString()
    )
}