package com.example.text_presentation_feature.mapper

import com.example.banner_api.Banner
import com.example.text_presentation_feature.GroupItem

class BannerDomainToUi : suspend (Banner) -> GroupItem {

    private val grouped = GroupedBannerDomainToUi()

    override suspend fun invoke(input: Banner) = GroupItem(
        id = input.id,
        text = input.text,
        color = input.color,
        presentation = input.presentation,
        list = input.list.map { grouped.invoke(it) }
    )

}