package com.example.color_impl

import com.example.color_api.ColorRepo
import javax.inject.Inject
import kotlin.random.Random

class ColorRepoImpl @Inject constructor() : ColorRepo {

    private var color = "#89CFF0"

    override suspend fun color(id: String) = color

    override suspend fun change(id: String) = generate().also {
        color = it
    }

    private fun generate(): String {
        val alpha = Integer.toHexString(255)
        val red = Integer.toHexString(Random.nextInt(256))
        val green = Integer.toHexString(Random.nextInt(256))
        val blue = Integer.toHexString(Random.nextInt(256))
        return "#$alpha$red$green$blue"
    }
}