package com.example.banner_api

interface BannerUseCase {
    suspend fun banners(): List<Banner>
}