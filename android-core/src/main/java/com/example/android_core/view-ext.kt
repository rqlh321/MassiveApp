package com.example.android_core

import android.view.View

fun View.click(action: () -> Unit) = setOnClickListener { action.invoke() }