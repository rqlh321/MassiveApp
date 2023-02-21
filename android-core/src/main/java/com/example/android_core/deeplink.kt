package com.example.android_core

import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest

fun Fragment.deeplinkColorSetup(id: Long) = NavDeepLinkRequest.Builder
    .fromUri(getString(R.string.deeplink_schema_color_setup).replace("{id}", id.toString()).toUri())
    .build()

const val UPDATE_REQUEST_KEY = "request_update_key"
const val UPDATE_REQUEST_RESULT_KEY = "success_key"
const val SUCCESS_UPDATE_RESULT = "success"
const val FAIL_UPDATE_RESULT = "fail"