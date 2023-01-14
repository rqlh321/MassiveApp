package com.example.android_core

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Provider

abstract class CommonFragment2(layout: Int) : Fragment(layout) {

    @Inject
    protected lateinit var factorys: MutableMap<
            Class<out AbstractSavedStateViewModelFactory>,
            @JvmSuppressWildcards Provider<AbstractSavedStateViewModelFactory>
            >

    protected inline fun <reified F : AbstractSavedStateViewModelFactory, reified VM : CommonViewModel> viewModel(): VM {
        val factory = factorys[F::class.java]?.get() as F
        return ViewModelProvider(this, factory)[VM::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}