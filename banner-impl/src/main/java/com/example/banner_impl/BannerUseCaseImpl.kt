package com.example.banner_impl

import com.example.banner_api.Banner
import com.example.banner_api.BannerUseCase
import com.example.banner_api.GroupedBanner
import com.example.color_api.ColorRepo
import com.example.text_presentation_api.TextRepo
import javax.inject.Inject
import kotlin.random.Random

class BannerUseCaseImpl @Inject constructor(
    private val textRepo: TextRepo,
    private val colorRepo: ColorRepo,
) : BannerUseCase {

    override suspend fun banners() = generate()

    private suspend fun generate(): List<Banner> = (0..9).map {
        val id = it.toString()
        Banner(
            id = id,
            text = textRepo.text(id),
            color = colorRepo.color(id),
            presentation = Random.nextInt(0, 3),
            list = generateInternal()
        )
    }

    private suspend fun generateInternal(): List<GroupedBanner> = (0..9).map {
        val id = it.toString()
        GroupedBanner(
            id = id,
            text = textRepo.text(id),
            color = colorRepo.color(id),
        )
    }
}