package com.example.text_presentation_feature

data class TextPresentationViewState(
    val text: CharSequence,
    val color: String,
)

data class TextPresentationItem(
    val id: CharSequence,
    val text: CharSequence,
    val color: String,
    val list: List<TextPresentationItem>,
)