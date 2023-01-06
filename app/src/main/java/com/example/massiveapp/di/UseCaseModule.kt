package com.example.massiveapp.di

import com.example.banner_api.BannerUseCase
import com.example.banner_impl.BannerUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface UseCaseModule {

    @Singleton
    @Binds
    fun bannerUseCase(impl: BannerUseCaseImpl): BannerUseCase

}