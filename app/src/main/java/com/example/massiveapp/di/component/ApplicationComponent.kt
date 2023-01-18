package com.example.massiveapp.di.component

import android.content.Context
import com.example.massiveapp.ThisApp
import com.example.massiveapp.di.DataSourceModule
import com.example.massiveapp.di.RepoModule
import com.example.massiveapp.di.StoreModule
import com.example.massiveapp.di.UseCaseModule
import com.example.massiveapp.di.module.AppModule
import com.example.massiveapp.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,

        StoreModule::class,

        DataSourceModule::class,
        RepoModule::class,
        UseCaseModule::class,

        AppModule::class,
    ],
)
interface ApplicationComponent : AndroidInjector<ThisApp> {
    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(context: Context):Builder
    }
}