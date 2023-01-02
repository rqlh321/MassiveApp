package com.example.text_presentation_feature

import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import androidx.lifecycle.LifecycleCoroutineScope
import com.example.text_presentation_feature.databinding.TextPresentationFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TextPresentationRenderer(
    private val screenHolder: TextPresentationFragmentBinding,
    private val lifecycleScope: LifecycleCoroutineScope,
) : (TextPresentationViewState) -> Unit {

    override fun invoke(viewState: TextPresentationViewState) {
        lifecycleScope.launch {
            val precomputedText = withContext(Dispatchers.Default) {
                val params = TextViewCompat.getTextMetricsParams(screenHolder.text)
                PrecomputedTextCompat.create(viewState.text, params)
            }
            TextViewCompat.setPrecomputedText(screenHolder.text, precomputedText)
        }
    }
}