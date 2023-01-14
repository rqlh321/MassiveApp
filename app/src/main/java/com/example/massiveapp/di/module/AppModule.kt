package com.example.massiveapp.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.android_core.ViewModelFactory
import com.example.color_setup_feature.ColorSetupFragment
import com.example.massiveapp.di.scope.AppScope
import com.example.massiveapp.di.scope.FeatureScope
import com.example.text_presentation_feature.TextPresentationFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @Binds
    @AppScope
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = [PresentationModule::class])
    @FeatureScope
    fun textPresentationFragment(): TextPresentationFragment

    @ContributesAndroidInjector(modules = [EditModule::class])
    @FeatureScope
    fun colorSetupFragment(): ColorSetupFragment
}