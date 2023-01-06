package com.example.color_api

interface ColorRepo {
    suspend fun color(id: String): String
    suspend fun change(id: String): String
}