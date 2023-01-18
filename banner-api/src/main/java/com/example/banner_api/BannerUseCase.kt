package com.example.banner_api

import kotlinx.coroutines.flow.Flow

interface BannerUseCase {
    fun banners(): Flow<List<Banner>>
}