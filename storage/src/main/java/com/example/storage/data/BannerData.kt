package com.example.storage.data

open class BannerData(
    val id: String,
    val text: CharSequence,
    val color: String,
    val presentation: Int,
    val list: List<GroupedBannerData>,
)