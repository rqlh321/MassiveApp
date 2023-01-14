package com.example.massiveapp.di.component

import com.example.massiveapp.ThisApp
import com.example.massiveapp.di.RepoModule
import com.example.massiveapp.di.UseCaseModule
import com.example.massiveapp.di.module.AppModule
import com.example.massiveapp.di.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,

        RepoModule::class,
        UseCaseModule::class,

        AppModule::class,
    ],
)
interface ApplicationComponent : AndroidInjector<ThisApp>