package com.example.text_presentation_feature.action.impl

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.lifecycle.MutableLiveData
import com.example.color_api.ColorRepo
import com.example.text_presentation_api.TextRepo
import com.example.text_presentation_feature.TextPresentationViewState
import com.example.text_presentation_feature.action.SetPreviewTextAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SetPreviewTextActionImpl @Inject constructor(
    private val textRepo: TextRepo,
    private val colorRepo: ColorRepo,
    private val mutableViewState: MutableLiveData<TextPresentationViewState>,
) : SetPreviewTextAction {

    override suspend fun invoke() {
        val (text, color) = withContext(Dispatchers.IO) {
            ColoredText(
                text = textRepo.main(),
                color = colorRepo.main()
            )
        }
        val spannableString = SpannableString(text).apply {
            setSpan(
                ForegroundColorSpan(Color.parseColor(color)),
                0,
                text.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        mutableViewState.value = TextPresentationViewState(
            text = spannableString
        )
    }

}

data class ColoredText(
    val text: CharSequence,
    val color: String,
)