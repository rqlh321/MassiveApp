package com.example.text_impl

import com.example.text_presentation_api.TextRepo
import javax.inject.Inject

class TextRepoImpl @Inject constructor() : TextRepo {
    override suspend fun main() = "Text: ${hashCode()}"
}