package com.example.banner_impl

import com.example.banner_api.Banner
import com.example.banner_api.BannerRepo
import com.example.banner_api.GroupedBanner
import com.example.storage.BannerStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BannerRepoImpl @Inject constructor(
    private val store: BannerStore
) : BannerRepo {

    override fun banners(): Flow<List<Banner>> = store.banners()
        .map {
            it.map { groupData ->
                Banner(
                    id = groupData.id,
                    text = groupData.text,
                    color = groupData.color,
                    presentation = groupData.presentation,
                    list = groupData.list.map { bannerData ->
                        GroupedBanner(
                            id = bannerData.id,
                            text = bannerData.text,
                            color = bannerData.color,
                        )
                    }
                )
            }
        }
}