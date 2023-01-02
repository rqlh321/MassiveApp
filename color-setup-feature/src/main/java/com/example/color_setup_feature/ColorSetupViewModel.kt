package com.example.color_setup_feature

import android.graphics.Color
import com.example.android_core.CommonViewModel
import com.example.color_api.ColorRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ColorSetupViewModel @Inject constructor(
    private val colorRepo: ColorRepo
) : CommonViewModel() {

    private val _uiState = MutableStateFlow(ColorSetupViewState(Color.TRANSPARENT))
    val uiState: StateFlow<ColorSetupViewState> = _uiState

    init {
        launch {
            val color = Color.parseColor(colorRepo.main())
            _uiState.emit(ColorSetupViewState(color = color))
        }
    }

    fun changeColor() = launch {
        val newColor = colorRepo.change()
        _uiState.emit(ColorSetupViewState(color = Color.parseColor(newColor)))
    }

}