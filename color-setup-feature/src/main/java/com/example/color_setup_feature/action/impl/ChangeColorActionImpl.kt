package com.example.color_setup_feature.action.impl

import android.graphics.Color
import com.example.color_api.ColorRepo
import com.example.color_setup_feature.ColorSetupViewState
import com.example.color_setup_feature.action.ChangeColorAction
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ChangeColorActionImpl @Inject constructor(
    private val colorRepo: ColorRepo,
    private val flow: MutableStateFlow<ColorSetupViewState>,
) : ChangeColorAction {
    override suspend fun invoke(id: String) {
        val newColor = colorRepo.change(id)
        flow.emit(ColorSetupViewState(color = Color.parseColor(newColor)))
    }
}