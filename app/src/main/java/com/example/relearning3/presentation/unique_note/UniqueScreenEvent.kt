package com.example.relearning3.presentation.unique_note

sealed class UniqueScreenEvent {
    data class Title(val data: String): UniqueScreenEvent()
    data class Body(val data: String): UniqueScreenEvent()
    data class pTag(val data: String): UniqueScreenEvent()
    data class sTag(val data: String): UniqueScreenEvent()
}