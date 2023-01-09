package com.example.color_setup_feature

import android.graphics.Color
import com.example.android_core.CommonViewModel
import com.example.color_api.ColorRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ColorSetupViewModel @Inject constructor(
    val uiState: StateFlow<ColorSetupViewState>,
//    private val id: String,
    private val _uiState: MutableStateFlow<ColorSetupViewState>,
    private val colorRepo: ColorRepo,
) : CommonViewModel() {

    init {
        launch {
            val color = Color.parseColor(colorRepo.color("args.id"))
            _uiState.emit(ColorSetupViewState(color = color))
        }
    }

    fun changeColor(id: String) = launch {
        val newColor = colorRepo.change(id)
        _uiState.emit(ColorSetupViewState(color = Color.parseColor(newColor)))
    }

}