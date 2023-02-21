package com.example.massiveapp.di

import com.example.banner_api.BannerDescription
import com.example.banner_api.BannerGroup
import com.example.banner_impl.mapper.BannerDescriptionDatabaseToDomain
import com.example.banner_impl.mapper.BannerGroupDatabaseToDomain
import com.example.banner_impl.mapper.Convertor
import com.example.massiveapp.di.scope.AppScope
import com.example.sqldelight.BannerGroupEntity
import com.example.sqldelight.BannerDescriptionEntity
import dagger.Binds
import dagger.Module

@Module
interface MapperModule {

    @AppScope
    @Binds
    fun bannerGroupDatabaseToDomain(
        impl: BannerGroupDatabaseToDomain
    ): Convertor<BannerGroupEntity, BannerGroup>

    @AppScope
    @Binds
    fun bannerDescriptionDatabaseToDomain(
        impl: BannerDescriptionDatabaseToDomain
    ): Convertor<BannerDescriptionEntity, BannerDescription>
}