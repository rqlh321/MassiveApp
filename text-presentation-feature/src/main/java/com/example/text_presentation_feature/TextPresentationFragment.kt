package com.example.text_presentation_feature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.android_core.*
import com.example.text_presentation_feature.adapter.BannerAdapter
import com.example.text_presentation_feature.adapter.decoration.PaddingDecoration
import com.example.text_presentation_feature.databinding.TextPresentationFragmentBinding
import kotlinx.coroutines.launch

class TextPresentationFragment : CommonFragment(R.layout.text_presentation_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = viewModel<TextPresentationViewModel>()
        val screenHolder = TextPresentationFragmentBinding.bind(view)
        val renderer = TextPresentationRenderer(screenHolder)

        screenHolder.list.addItemDecoration(PaddingDecoration(view.context))
        screenHolder.list.adapter = BannerAdapter()
        screenHolder.button.click { findNavController().navigate(deeplinkColorSetup("123")) }

        setFragmentResultListener(UPDATE_REQUEST_KEY) { _, bundle ->
            if (bundle.getString(UPDATE_REQUEST_RESULT_KEY) == SUCCESS_UPDATE_RESULT) {
                viewModel.update()
            }
        }

        lifecycleScope.launch { viewModel.viewState.collect(renderer::invoke) }
    }

}