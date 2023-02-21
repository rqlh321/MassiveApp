package com.example.banner_impl

import com.example.banner_api.BannerGroup
import com.example.banner_api.BannerRepo
import com.example.banner_impl.mapper.Convertor
import com.example.sqldelight.BannerGroupEntity
import com.example.storage.BannerStore
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BannerRepoImpl @Inject constructor(
    private val store: BannerStore,
    private val databaseToDomain: Convertor<BannerGroupEntity, BannerGroup>,
) : BannerRepo {

    override fun banners() = store.groupsWithDescriptions()
        .map { it.map(databaseToDomain) }

    override suspend fun addBanner(
        text: String,
        color: String
    ) = store.createGroup(
        text = text,
        color = color
    )
}