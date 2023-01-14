package com.example.massiveapp.di

import com.example.color_api.ColorRepo
import com.example.color_impl.ColorRepoImpl
import com.example.massiveapp.di.scope.AppScope
import com.example.text_impl.TextRepoImpl
import com.example.text_presentation_api.TextRepo
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {

    @AppScope
    @Binds
    fun textRepo(impl: TextRepoImpl): TextRepo

    @AppScope
    @Binds
    fun colorRepo(impl: ColorRepoImpl): ColorRepo

}