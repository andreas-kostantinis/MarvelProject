package com.example.myapplication.api

import com.example.myapplication.Data

data class HeroesService(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)