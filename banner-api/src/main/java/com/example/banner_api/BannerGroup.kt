package com.example.banner_api

data class BannerGroup(
    val id: Long,
    val text: CharSequence,
    val color: String,
    val presentation: Int,
    val list: List<BannerDescription>,
) {
    companion object {
        const val PRESENTATION_SINGLE = 0
        const val PRESENTATION_GRID = 1
        const val PRESENTATION_LIST = 2
    }
}