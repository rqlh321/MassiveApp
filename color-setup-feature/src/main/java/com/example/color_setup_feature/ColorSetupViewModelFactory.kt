package com.example.color_setup_feature

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.color_api.ColorRepo
import com.example.color_setup_feature.action.ChangeColorAction
import com.example.color_setup_feature.action.SetColorAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ColorSetupViewModelFactory @Inject constructor(
    private val uiState: StateFlow<ColorSetupViewState>,
    private val setColorAction: SetColorAction,
    private val changeColorAction: ChangeColorAction,
) : AbstractSavedStateViewModelFactory() {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T = ColorSetupViewModel(
        id = ColorSetupFragmentArgs.fromSavedStateHandle(handle).id,
        uiState = uiState,
        setColorAction = setColorAction,
        changeColorAction = changeColorAction,
    ) as T
}