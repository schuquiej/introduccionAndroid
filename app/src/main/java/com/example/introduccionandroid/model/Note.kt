package com.example.introduccionandroid.model

data class Note(
    val id: Long = System.currentTimeMillis(), // ID simple
    val text: String
)
