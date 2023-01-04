package com.example.text_presentation_feature

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import com.example.text_presentation_feature.adapter.BannerListAdapter
import com.example.text_presentation_feature.databinding.TextPresentationFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TextPresentationRenderer(
    private val screenHolder: TextPresentationFragmentBinding,
) : suspend (TextPresentationViewState) -> Unit {

    override suspend fun invoke(viewState: TextPresentationViewState) {
        val list = (0..100).map {
            TextPresentationItem(
                it.toString(),
                text = it.toString(),
                color = "#000000",
                list = if (it % 2 == 0) emptyList() else (0..100).map {
                    TextPresentationItem(
                        it.toString(),
                        text = it.toString(),
                        color = "#000000",
                        list = emptyList()
                    )
                }
            )
        }
        (screenHolder.list.adapter as BannerListAdapter).submitList(list)
        val precomputedText = withContext(Dispatchers.Default) {
            val params = TextViewCompat.getTextMetricsParams(screenHolder.text)
            val spannableString = SpannableString(viewState.text).apply {
                setSpan(
                    ForegroundColorSpan(Color.parseColor(viewState.color)),
                    0,
                    viewState.text.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            PrecomputedTextCompat.create(spannableString, params)
        }

        TextViewCompat.setPrecomputedText(
            screenHolder.text,
            precomputedText
        )
    }
}