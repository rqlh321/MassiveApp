package com.example.storage

import com.example.storage.data.BannerData
import com.example.storage.data.GroupedBannerData
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BannerStoreMock @Inject constructor() : BannerStore {
    override fun banners() = flow {
        val generated = generate()
        emit(generated)
    }

    private suspend fun generate(): List<BannerData> = (0..2).map {
        val id = it.toString()
        BannerData(
            id = id,
            text = id,
            color = "#89CFF0",
            presentation = it,
            list = generateInternal(id)
        )
    }

    private suspend fun generateInternal(parentId: String): List<GroupedBannerData> = (0..9).map {
        val id = "$parentId$it"
        GroupedBannerData(
            id = id,
            text = id,
            color = "#89CFF0",
        )
    }
}