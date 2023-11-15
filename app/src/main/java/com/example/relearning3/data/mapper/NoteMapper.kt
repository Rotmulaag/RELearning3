package com.example.relearning3.data.mapper

import com.example.relearning3.data.local.entity.NoteEntity
import com.example.relearning3.domain.model.Note

fun toList(string: String): List<String> {
    val list = emptyList<String>().toMutableList()
    var word = ""

    for (c in string)
        if (c != ',')
            word.plus(c)
        else {
            list.add(word)
            word = ""
        }

    return list
}

fun fromList(list: List<String>): String {
    return list.toString()
}

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        body = body,
        date = date,
        primaryTags = toList(primaryTags),
        secondaryTags = toList(secondaryTags)
    )
}

fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        title = title,
        body = body,
        date = date,
        primaryTags = fromList(primaryTags),
        secondaryTags = fromList(secondaryTags)
    )
}