package com.example.banner_impl.mapper

import com.example.banner_api.BannerDescription
import com.example.banner_api.BannerGroup
import com.example.sqldelight.BannerGroupEntity
import com.example.sqldelight.BannerDescriptionEntity
import javax.inject.Inject

class BannerGroupDatabaseToDomain @Inject constructor(
    private val mapper: Convertor<BannerDescriptionEntity, BannerDescription>
) : Convertor<BannerGroupEntity, BannerGroup> {
    override fun invoke(input: BannerGroupEntity) = BannerGroup(
        id = input.id,
        text = input.text,
        color = input.color,
        presentation = BannerGroup.PRESENTATION_SINGLE,
        list = emptyList()
    )
}