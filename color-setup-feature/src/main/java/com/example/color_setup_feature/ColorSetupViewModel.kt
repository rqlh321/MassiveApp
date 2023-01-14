package com.example.color_setup_feature

import com.example.android_core.CommonViewModel
import com.example.color_setup_feature.action.ChangeColorAction
import com.example.color_setup_feature.action.SetColorAction
import kotlinx.coroutines.flow.StateFlow

class ColorSetupViewModel(
    val uiState: StateFlow<ColorSetupViewState>,
    private val id: String,
    private val setColorAction: SetColorAction,
    private val changeColorAction: ChangeColorAction,
) : CommonViewModel() {

    init {
        launch { setColorAction(id) }
    }

    fun changeColor() = launch { changeColorAction(id) }

}