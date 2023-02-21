package com.example.storage

import app.cash.sqldelight.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class BannerStoreDelight @Inject constructor(
    database: Database
) : BannerStore {

    private val queries = database.bannerGroupEntityQueries

    override fun groupsWithDescriptions() = callbackFlow {
        val bannerQuery = queries.selectAll()
        trySendBlocking(bannerQuery.executeAsList())
        val listener = Query.Listener {
            trySendBlocking(bannerQuery.executeAsList())
        }
        bannerQuery.addListener(listener)
        awaitClose { bannerQuery.removeListener(listener) }
    }

    override suspend fun createGroup(
        text: String,
        color: String
    ) = queries.create(
        text = text,
        color = color,
    )

}