package com.example.text_presentation_feature

import com.example.android_core.CommonViewModel
import com.example.text_presentation_feature.action.SetPreviewTextAction
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TextPresentationViewModel @Inject constructor(
    val viewState: StateFlow<TextPresentationViewState>,
    setPreviewTextAction: SetPreviewTextAction,
) : CommonViewModel() {

    init {
        launch(setPreviewTextAction)
    }

//    fun update() = launch(setPreviewTextAction)
}