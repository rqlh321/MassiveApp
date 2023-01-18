package com.example.text_presentation_feature.action.impl

import com.example.banner_api.BannerUseCase
import com.example.text_presentation_feature.TextPresentationViewState
import com.example.text_presentation_feature.action.SetPreviewTextAction
import com.example.text_presentation_feature.mapper.BannerDomainToUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SetPreviewTextActionImpl @Inject constructor(
    private val bannerUseCase: BannerUseCase,
    private val mutableViewState: MutableStateFlow<TextPresentationViewState>,
) : SetPreviewTextAction {

    private val domainToUi = BannerDomainToUi()

    override suspend fun invoke() = bannerUseCase.banners()
        .map(domainToUi)
        .onEach { mutableViewState.emit(TextPresentationViewState(it)) }
        .collect()
}