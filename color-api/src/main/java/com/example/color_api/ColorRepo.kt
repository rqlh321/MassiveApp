package com.example.color_api

interface ColorRepo {
    suspend fun main(): String
    suspend fun change(): String
}