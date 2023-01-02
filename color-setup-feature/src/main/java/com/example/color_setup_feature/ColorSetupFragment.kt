package com.example.color_setup_feature

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.android_core.*
import com.example.color_setup_feature.databinding.ColorSetupFragmentBinding
import kotlinx.coroutines.launch

class ColorSetupFragment : CommonFragment(R.layout.color_setup_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = viewModel<ColorSetupViewModel>()
        val screenHolder = ColorSetupFragmentBinding.bind(view)

        screenHolder.changeColorButton.click {
            viewModel.changeColor()
            setFragmentResult(
                UPDATE_REQUEST_KEY,
                bundleOf(UPDATE_REQUEST_RESULT_KEY to SUCCESS_UPDATE_RESULT)
            )
        }

        // Start a coroutine in the lifecycle scope
        lifecycleScope.launch {
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Trigger the flow and start listening for values.
                // Note that this happens when lifecycle is STARTED and stops
                // collecting when the lifecycle is STOPPED
                viewModel.uiState.collect { uiState ->
                    screenHolder.currentColor.setBackgroundColor(uiState.color)
                }
            }
        }

    }
}