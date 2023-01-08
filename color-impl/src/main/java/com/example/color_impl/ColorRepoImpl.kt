package com.example.color_impl

import com.example.color_api.ColorRepo
import javax.inject.Inject
import kotlin.random.Random

class ColorRepoImpl @Inject constructor() : ColorRepo {

    private val defaultColor = "#89CFF0"

    private val colors = hashMapOf<String, String>()

    override suspend fun color(id: String) = colors[id] ?: defaultColor

    override suspend fun change(id: String) = generate().also {
        colors[id] = it
        return it
    }

    private fun generate(): String {
        val alpha = Integer.toHexString(255)
        val red = Integer.toHexString(Random.nextInt(256))
        val green = Integer.toHexString(Random.nextInt(256))
        val blue = Integer.toHexString(Random.nextInt(256))
        return "#$alpha$red$green$blue"
    }
}