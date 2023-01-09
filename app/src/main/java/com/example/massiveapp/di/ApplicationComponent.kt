package com.example.massiveapp.di

import com.example.color_setup_feature.ColorSetupFragment
import com.example.massiveapp.ThisApp
import com.example.massiveapp.di.feature.EditSubcomponent
import com.example.massiveapp.di.feature.PresentationSubcomponent
import com.example.text_presentation_feature.TextPresentationFragment
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        EditSubcomponent::class,
        PresentationSubcomponent::class,
    ]
)
interface AppModule {
    @Binds
    @IntoMap
    @ClassKey(TextPresentationFragment::class)
    fun bindPresentationSubcomponent(factory: PresentationSubcomponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(ColorSetupFragment::class)
    fun bindEditSubcomponent(factory: EditSubcomponent.Factory): AndroidInjector.Factory<*>
}

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        RepoModule::class,
        UseCaseModule::class,
        ViewModelModule::class,
        AppModule::class,
    ],
)
interface ApplicationComponent : AndroidInjector<ThisApp>