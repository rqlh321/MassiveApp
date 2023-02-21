package com.example.storage

import com.example.sqldelight.BannerGroupEntity
import kotlinx.coroutines.flow.Flow

interface BannerStore {

    fun groupsWithDescriptions(): Flow<List<BannerGroupEntity>>

    suspend fun createGroup(text: String, color: String)

}