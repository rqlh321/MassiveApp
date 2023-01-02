package com.example.massiveapp.di

import com.example.color_api.ColorRepo
import com.example.color_impl.ColorRepoImpl
import com.example.text_impl.TextRepoImpl
import com.example.text_presentation_api.TextRepo
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepoModule {

    @Singleton
    @Binds
    fun textRepo(impl: TextRepoImpl): TextRepo

    @Singleton
    @Binds
    fun colorRepo(impl: ColorRepoImpl): ColorRepo

}