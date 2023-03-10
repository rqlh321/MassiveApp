package com.example.massiveapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.color_impl.PersonalPreferencesSerializer
import com.example.color_impl.banner.PersonalPreferences
import com.example.massiveapp.di.scope.AppScope
import com.example.storage.Database
import dagger.Module
import dagger.Provides
import java.io.File

@Module
interface DataSourceModule {

    companion object {

        @Provides
        @AppScope
        fun providerSqlDriver(context: Context): Database {
            return Database(AndroidSqliteDriver(Database.Schema, context, "test.db"))
        }

        @Provides
        @AppScope
        fun providerDataStore(context: Context): DataStore<PersonalPreferences> {
            return DataStoreFactory.create(
                serializer = PersonalPreferencesSerializer,
                produceFile = { File("${context.cacheDir.path}/massiveapp.preferences_pb") },
            )
        }
    }
}