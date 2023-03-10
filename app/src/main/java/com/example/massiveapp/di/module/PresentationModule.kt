package com.example.massiveapp.di.module

import androidx.lifecycle.ViewModel
import com.example.massiveapp.di.ViewModelKey
import com.example.massiveapp.di.scope.FeatureScope
import com.example.text_presentation_feature.TextPresentationViewModel
import com.example.text_presentation_feature.TextPresentationViewState
import com.example.text_presentation_feature.action.AddBannerAction
import com.example.text_presentation_feature.action.SetPreviewTextAction
import com.example.text_presentation_feature.action.impl.AddBannerActionImpl
import com.example.text_presentation_feature.action.impl.SetPreviewTextActionImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
interface PresentationModule {

    @Binds
    fun bindViewState(impl: MutableStateFlow<TextPresentationViewState>): StateFlow<TextPresentationViewState>

    @Binds
    fun bindSetPreviewTextAction(impl: SetPreviewTextActionImpl): SetPreviewTextAction

    @Binds
    fun bindAddBannerAction(impl: AddBannerActionImpl): AddBannerAction

    @Binds
    @IntoMap
    @ViewModelKey(TextPresentationViewModel::class)
    fun textPresentationViewModel(viewModel: TextPresentationViewModel): ViewModel

    companion object {
        @FeatureScope
        @Provides
        fun provideTextPresentationViewState(): MutableStateFlow<TextPresentationViewState> {
            return MutableStateFlow(TextPresentationViewState(emptyList()))
        }

    }
}