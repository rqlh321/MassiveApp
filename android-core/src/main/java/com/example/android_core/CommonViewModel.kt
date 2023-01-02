package com.example.android_core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

abstract class CommonViewModel : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.d(this::class.simpleName, exception.message, exception)
    }

    protected fun launch(action: suspend () -> Unit) {
        viewModelScope.launch(handler) {
            action.invoke()
        }
    }
}