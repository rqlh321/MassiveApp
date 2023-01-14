package com.example.massiveapp.di

import com.example.banner_api.BannerUseCase
import com.example.banner_impl.BannerUseCaseImpl
import com.example.massiveapp.di.scope.AppScope
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    @AppScope
    fun bannerUseCase(impl: BannerUseCaseImpl): BannerUseCase

}