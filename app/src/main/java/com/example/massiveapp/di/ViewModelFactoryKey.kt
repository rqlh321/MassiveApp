package com.example.massiveapp.di

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import dagger.MapKey
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelFactoryKey(val value: KClass<out AbstractSavedStateViewModelFactory>)