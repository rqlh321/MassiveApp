package com.example.massiveapp.di

import com.example.massiveapp.di.scope.AppScope
import com.example.storage.BannerStore
import com.example.storage.BannerStoreMock
import dagger.Binds
import dagger.Module

@Module
interface StoreModule {

    @AppScope
    @Binds
    fun bindBannerStore(impl: BannerStoreMock): BannerStore
}