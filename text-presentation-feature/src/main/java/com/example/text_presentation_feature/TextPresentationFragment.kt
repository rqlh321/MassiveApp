package com.example.text_presentation_feature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.android_core.*
import com.example.text_presentation_feature.adapter.BannerAdapter
import com.example.text_presentation_feature.adapter.decoration.PaddingDecoration
import com.example.text_presentation_feature.databinding.TextPresentationFragmentBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class TextPresentationFragment : CommonFragment(R.layout.text_presentation_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = viewModel<TextPresentationViewModel>()
        val screenHolder = TextPresentationFragmentBinding.bind(view)
        val renderer = TextPresentationRenderer(screenHolder)

        screenHolder.button.setOnClickListener {
            viewModel.addBanner()
        }
        screenHolder.list.addItemDecoration(PaddingDecoration(view.context))
        screenHolder.list.setHasFixedSize(true)
        screenHolder.list.adapter = BannerAdapter {
            findNavController().navigate(deeplinkColorSetup(it))
        }
        (screenHolder.list.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false

        setFragmentResultListener(UPDATE_REQUEST_KEY) { _, bundle ->
            val result = bundle.getString(UPDATE_REQUEST_RESULT_KEY)
            if (result == SUCCESS_UPDATE_RESULT) {
//                viewModel.update()
            }
        }

        viewModel.viewState
            .flowWithLifecycle(lifecycle)
            .onEach(renderer)
            .launchIn(lifecycleScope)
    }

}