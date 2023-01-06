package com.example.massiveapp.di.feature

import androidx.lifecycle.ViewModel
import com.example.massiveapp.di.ViewModelKey
import com.example.text_presentation_feature.TextPresentationFragment
import com.example.text_presentation_feature.TextPresentationViewModel
import com.example.text_presentation_feature.TextPresentationViewState
import com.example.text_presentation_feature.action.SetPreviewTextAction
import com.example.text_presentation_feature.action.impl.SetPreviewTextActionImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Singleton


@Subcomponent
interface PresentationSubcomponent : AndroidInjector<TextPresentationFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<TextPresentationFragment>
}

@Module(subcomponents = [PresentationSubcomponent::class])
interface PresentationModule {

    @Binds
    fun bindViewState(impl: MutableStateFlow<TextPresentationViewState>): StateFlow<TextPresentationViewState>

    @Binds
    fun bindSetPreviewTextAction(impl: SetPreviewTextActionImpl): SetPreviewTextAction

    @Binds
    @IntoMap
    @ClassKey(TextPresentationFragment::class)
    fun bind(factory: PresentationSubcomponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ViewModelKey(TextPresentationViewModel::class)
    fun textPresentationViewModel(viewModel: TextPresentationViewModel): ViewModel

    companion object {
        @Provides
        @Singleton
        fun provideTextPresentationViewState(): MutableStateFlow<TextPresentationViewState> {
            return MutableStateFlow(TextPresentationViewState("", "#ffffff", emptyList()))
        }

    }
}