package com.example.text_presentation_feature.action.impl

import com.example.banner_api.BannerUseCase
import com.example.text_presentation_feature.action.AddBannerAction
import javax.inject.Inject

class AddBannerActionImpl @Inject constructor(
    private val bannerUseCase: BannerUseCase,
) : AddBannerAction {
    override suspend fun invoke() = bannerUseCase.addBanner(
        "123", "#89CFF0"
    )
}