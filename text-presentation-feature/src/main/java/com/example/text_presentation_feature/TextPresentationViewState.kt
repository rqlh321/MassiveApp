package com.example.text_presentation_feature

data class TextPresentationViewState(
    val groups: List<GroupItem>,
)

data class GroupItem(
    val id: Long,
    val text: CharSequence,
    val color: String,
    val presentation: Int,
    val list: List<GroupedBannerItem>,
)

data class GroupedBannerItem(
    val id: Long,
    val text: CharSequence,
    val color: String,
)