package com.example.color_setup_feature

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.android_core.*
import com.example.color_setup_feature.databinding.ColorSetupFragmentBinding
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ColorSetupFragment : Fragment(R.layout.color_setup_fragment) {

    @Inject
    protected lateinit var factorys: MutableMap<
            Class<out AbstractSavedStateViewModelFactory>,
            @JvmSuppressWildcards Provider<AbstractSavedStateViewModelFactory>
            >

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(
            this,
            factorys[ColorSetupViewModelFactory::class.java]?.get() as ColorSetupViewModelFactory
        )[ColorSetupViewModel::class.java]

        val screenHolder = ColorSetupFragmentBinding.bind(view)

        screenHolder.changeColorButton.click {
            viewModel.changeColor()
            setFragmentResult(
                UPDATE_REQUEST_KEY,
                bundleOf(UPDATE_REQUEST_RESULT_KEY to SUCCESS_UPDATE_RESULT)
            )
        }

        lifecycleScope.launch {
            viewModel.uiState.flowWithLifecycle(lifecycle).collect { uiState ->
                screenHolder.currentColor.backgroundTintList = ColorStateList.valueOf(uiState.color)
            }
        }

    }
}