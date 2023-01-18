package com.example.color_impl

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.color_impl.banner.PersonalPreferences
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object PersonalPreferencesSerializer : Serializer<PersonalPreferences> {

    override val defaultValue: PersonalPreferences = PersonalPreferences.getDefaultInstance()

    override suspend fun readFrom(
        input: InputStream
    ): PersonalPreferences {
        try {
            return PersonalPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: PersonalPreferences,
        output: OutputStream
    ) = t.writeTo(output)
}