package com.example.storage

import com.example.storage.data.BannerData
import kotlinx.coroutines.flow.Flow

interface BannerStore {

    fun banners(): Flow<List<BannerData>>
}