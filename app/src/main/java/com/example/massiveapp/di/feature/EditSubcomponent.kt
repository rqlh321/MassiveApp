package com.example.massiveapp.di.feature

import androidx.lifecycle.ViewModel
import com.example.color_setup_feature.ColorSetupFragment
import com.example.color_setup_feature.ColorSetupViewModel
import com.example.massiveapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Subcomponent
interface EditSubcomponent : AndroidInjector<ColorSetupFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ColorSetupFragment>
}

@Module(subcomponents = [EditSubcomponent::class])
interface EditModule {
    @Binds
    @IntoMap
    @ClassKey(ColorSetupFragment::class)
    fun bind(factory: EditSubcomponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ViewModelKey(ColorSetupViewModel::class)
    fun colorSetupViewModel(viewModel: ColorSetupViewModel): ViewModel
}