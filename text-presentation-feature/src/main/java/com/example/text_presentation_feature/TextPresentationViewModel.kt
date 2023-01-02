package com.example.text_presentation_feature

import androidx.lifecycle.LiveData
import com.example.android_core.CommonViewModel
import com.example.text_presentation_feature.action.SetPreviewTextAction
import javax.inject.Inject

class TextPresentationViewModel @Inject constructor(
    val viewState: LiveData<TextPresentationViewState>,
    private val setPreviewTextAction: SetPreviewTextAction,
) : CommonViewModel() {

    init {
        launch {
            setPreviewTextAction.invoke()
        }
    }

    fun update() {
        launch {
            setPreviewTextAction.invoke()
        }
    }
}