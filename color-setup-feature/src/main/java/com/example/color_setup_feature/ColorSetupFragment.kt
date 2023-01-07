package com.example.color_setup_feature

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.android_core.*
import com.example.color_setup_feature.databinding.ColorSetupFragmentBinding
import kotlinx.coroutines.launch

class ColorSetupFragment : CommonFragment(R.layout.color_setup_fragment) {

    private val args: ColorSetupFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = viewModel<ColorSetupViewModel>()
        val screenHolder = ColorSetupFragmentBinding.bind(view)

        Toast.makeText(requireContext(),args.id,Toast.LENGTH_SHORT).show()

        screenHolder.changeColorButton.click {
            viewModel.changeColor()
            setFragmentResult(
                UPDATE_REQUEST_KEY,
                bundleOf(UPDATE_REQUEST_RESULT_KEY to SUCCESS_UPDATE_RESULT)
            )
        }

        lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                screenHolder.currentColor.setBackgroundColor(uiState.color)
            }
        }

    }
}