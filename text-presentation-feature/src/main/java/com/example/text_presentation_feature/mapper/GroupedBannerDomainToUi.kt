package com.example.text_presentation_feature.mapper

import com.example.banner_api.BannerDescription
import com.example.text_presentation_feature.GroupedBannerItem

class GroupedBannerDomainToUi : suspend (BannerDescription) -> GroupedBannerItem {

    override suspend fun invoke(input: BannerDescription) = GroupedBannerItem(
        id = input.id,
        text = input.text,
        color = input.color,
    )
}