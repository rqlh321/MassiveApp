package com.example.text_presentation_feature.mapper

import com.example.banner_api.BannerGroup
import com.example.text_presentation_feature.GroupItem

class BannerDomainToUi : suspend (List<BannerGroup>) -> List<GroupItem> {

    private val grouped = GroupedBannerDomainToUi()

    override suspend fun invoke(banners: List<BannerGroup>) = banners.map { input ->
        GroupItem(
            id = input.id,
            text = input.text,
            color = input.color,
            presentation = input.presentation,
            list = input.list.map { grouped.invoke(it) }
        )
    }

}