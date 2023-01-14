package com.example.massiveapp.di.module

import android.graphics.Color
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import com.example.color_setup_feature.ColorSetupViewModelFactory
import com.example.color_setup_feature.ColorSetupViewState
import com.example.massiveapp.di.ViewModelFactoryKey
import com.example.massiveapp.di.scope.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
interface EditModule {

    @Binds
    fun bindViewState(impl: MutableStateFlow<ColorSetupViewState>): StateFlow<ColorSetupViewState>

    @Binds
    @IntoMap
    @ViewModelFactoryKey(ColorSetupViewModelFactory::class)
    fun mapFactory(viewModel: ColorSetupViewModelFactory): AbstractSavedStateViewModelFactory

    companion object {
        @FeatureScope
        @Provides
        fun provideColorViewState(): MutableStateFlow<ColorSetupViewState> {
            return MutableStateFlow(ColorSetupViewState(Color.TRANSPARENT))
        }

    }
}