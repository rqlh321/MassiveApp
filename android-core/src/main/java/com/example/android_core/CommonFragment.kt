package com.example.android_core

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class CommonFragment(layout: Int) : Fragment(layout) {

    @Inject
    protected lateinit var factory: ViewModelFactory

    protected inline fun <reified T : ViewModel> viewModel(): T =
        ViewModelProvider(this, factory)[T::class.java]

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}