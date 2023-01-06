package com.example.text_presentation_api

interface TextRepo {
    suspend fun main(): CharSequence
    suspend fun text(id: String): CharSequence
}