package com.example.banner_impl.mapper

import com.example.banner_api.BannerDescription
import com.example.sqldelight.BannerDescriptionEntity
import javax.inject.Inject

class BannerDescriptionDatabaseToDomain @Inject constructor(

) : Convertor<BannerDescriptionEntity, BannerDescription> {
    override fun invoke(input: BannerDescriptionEntity) = BannerDescription(
        id = input.id,
        text = input.text,
        color = input.color,
    )
}