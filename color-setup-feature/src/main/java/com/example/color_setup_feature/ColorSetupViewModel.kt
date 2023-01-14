package com.example.color_setup_feature

import android.graphics.Color
import androidx.lifecycle.SavedStateHandle
import com.example.android_core.CommonViewModel
import com.example.color_api.ColorRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ColorSetupViewModel (
    state: SavedStateHandle,
    val uiState: StateFlow<ColorSetupViewState>,
    private val _uiState: MutableStateFlow<ColorSetupViewState>,
    private val colorRepo: ColorRepo,
) : CommonViewModel() {

    private val args = ColorSetupFragmentArgs.fromSavedStateHandle(state)

    init {
        launch {
            val color = Color.parseColor(colorRepo.color(args.id))
            _uiState.emit(ColorSetupViewState(color = color))
        }
    }

    fun changeColor() = launch {
        val newColor = colorRepo.change(args.id)
        _uiState.emit(ColorSetupViewState(color = Color.parseColor(newColor)))
    }

}