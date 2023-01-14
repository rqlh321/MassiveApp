package com.example.color_setup_feature.action.impl

import android.graphics.Color
import com.example.color_api.ColorRepo
import com.example.color_setup_feature.ColorSetupViewState
import com.example.color_setup_feature.action.SetColorAction
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class SetColorActionImpl @Inject constructor(
    private val flow: MutableStateFlow<ColorSetupViewState>,
    private val colorRepo: ColorRepo,
) : SetColorAction {
    override suspend fun invoke(id: String) {
        val color = Color.parseColor(colorRepo.color(id))
        flow.emit(ColorSetupViewState(color = color))
    }
}