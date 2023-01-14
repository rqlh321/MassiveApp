package com.example.color_setup_feature

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.color_api.ColorRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Provider

class ColorSetupViewModelFactory @Inject constructor(
    private val uiState: StateFlow<ColorSetupViewState>,
    private val _uiState: MutableStateFlow<ColorSetupViewState>,
    private val colorRepo: ColorRepo,
) : AbstractSavedStateViewModelFactory() {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T  = ColorSetupViewModel(
        state = handle,
        uiState = uiState,
        _uiState = _uiState,
        colorRepo = colorRepo,
    ) as T
}