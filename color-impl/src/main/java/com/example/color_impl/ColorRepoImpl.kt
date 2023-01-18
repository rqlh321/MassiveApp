package com.example.color_impl

import androidx.datastore.core.DataStore
import com.example.color_api.ColorRepo
import com.example.color_impl.banner.PersonalPreferences
import kotlinx.coroutines.flow.first
import java.util.UUID
import javax.inject.Inject
import kotlin.random.Random

class ColorRepoImpl @Inject constructor(
    private val store: DataStore<PersonalPreferences>
) : ColorRepo {

    private val defaultColor = "#89CFF0"

    private val colors = hashMapOf<String, String>()

    override suspend fun color(id: String) = colors[id] ?: defaultColor

    override suspend fun change(id: String) = generate().also {
        store.updateData { PersonalPreferences.newBuilder().setPass("123").build() }
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