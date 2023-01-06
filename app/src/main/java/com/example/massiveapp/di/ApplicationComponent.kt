package com.example.massiveapp.di

import com.example.massiveapp.ThisApp
import com.example.massiveapp.di.feature.EditModule
import com.example.massiveapp.di.feature.PresentationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        RepoModule::class,
        UseCaseModule::class,
        ViewModelModule::class,
        PresentationModule::class,
        EditModule::class,
    ],
)
interface ApplicationComponent : AndroidInjector<ThisApp>