package com.example.banner_api

import kotlinx.coroutines.flow.Flow

interface BannerRepo {

    fun banners(): Flow<List<Banner>>
}