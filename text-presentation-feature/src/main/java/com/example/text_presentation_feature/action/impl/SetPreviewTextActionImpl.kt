package com.example.text_presentation_feature.action.impl

import com.example.banner_api.BannerUseCase
import com.example.color_api.ColorRepo
import com.example.text_presentation_api.TextRepo
import com.example.text_presentation_feature.TextPresentationViewState
import com.example.text_presentation_feature.action.SetPreviewTextAction
import com.example.text_presentation_feature.mapper.BannerDomainToUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SetPreviewTextActionImpl @Inject constructor(
    private val textRepo: TextRepo,
    private val colorRepo: ColorRepo,
    private val bannerUseCase: BannerUseCase,
    private val mutableViewState: MutableStateFlow<TextPresentationViewState>,
) : SetPreviewTextAction {

    private val mapper = BannerDomainToUi()

    override suspend fun invoke() {
        val state = withContext(Dispatchers.IO) {
            TextPresentationViewState(
                text = textRepo.main(),
                color = colorRepo.color(""),
                groups = bannerUseCase.banners()
                    .let {
                        withContext(Dispatchers.Default) {
                            it.map { banner -> mapper.invoke(banner) }
                        }
                    }
            )
        }
        mutableViewState.emit(state)
    }

}