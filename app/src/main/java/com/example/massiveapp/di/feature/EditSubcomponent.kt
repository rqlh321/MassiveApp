package com.example.massiveapp.di.feature

import android.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.color_setup_feature.ColorSetupFragment
import com.example.color_setup_feature.ColorSetupViewModel
import com.example.color_setup_feature.ColorSetupViewState
import com.example.massiveapp.di.FeatureScope
import com.example.massiveapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


@FeatureScope
@Subcomponent(modules = [EditModule::class])
interface EditSubcomponent : AndroidInjector<ColorSetupFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ColorSetupFragment>
}

@Module
interface EditModule {
    @Binds
    fun bindViewState(impl: MutableStateFlow<ColorSetupViewState>): StateFlow<ColorSetupViewState>

    @Binds
    @IntoMap
    @ViewModelKey(ColorSetupViewModel::class)
    fun colorSetupViewModel(viewModel: ColorSetupViewModel): ViewModel

    companion object {
        @FeatureScope
        @Provides
        fun provideColorViewState(): MutableStateFlow<ColorSetupViewState> {
            return MutableStateFlow(ColorSetupViewState(Color.TRANSPARENT))
        }

    }
}