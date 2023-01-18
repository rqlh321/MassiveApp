package com.example.banner_impl

import com.example.banner_api.BannerRepo
import com.example.banner_api.BannerUseCase
import javax.inject.Inject

class BannerUseCaseImpl @Inject constructor(
    private val repo: BannerRepo,
) : BannerUseCase {

    override fun banners() = repo.banners()

}