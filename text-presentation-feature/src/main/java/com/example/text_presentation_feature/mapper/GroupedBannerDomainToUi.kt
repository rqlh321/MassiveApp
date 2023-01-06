package com.example.text_presentation_feature.mapper

import com.example.banner_api.GroupedBanner
import com.example.text_presentation_feature.GroupedBannerItem

class GroupedBannerDomainToUi : suspend (GroupedBanner) -> GroupedBannerItem {

    override suspend fun invoke(input: GroupedBanner) = GroupedBannerItem(
        id = input.id,
        text = input.text,
        color = input.color,
    )
}