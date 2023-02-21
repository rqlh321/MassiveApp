package com.example.color_setup_feature

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.android_core.*
import com.example.color_setup_feature.databinding.ColorSetupFragmentBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ColorSetupFragment : CommonFragment2(R.layout.color_setup_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = viewModel<ColorSetupViewModelFactory, ColorSetupViewModel>()
        val screenHolder = ColorSetupFragmentBinding.bind(view)

        screenHolder.changeColorButton.click {
            viewModel.changeColor()
            setFragmentResult(
                UPDATE_REQUEST_KEY,
                bundleOf(UPDATE_REQUEST_RESULT_KEY to SUCCESS_UPDATE_RESULT)
            )
        }

        viewModel.uiState
            .flowWithLifecycle(lifecycle)
            .onEach { uiState ->
                screenHolder.currentColor
                    .backgroundTintList = ColorStateList.valueOf(uiState.color)
            }
            .launchIn(lifecycleScope)

    }
}