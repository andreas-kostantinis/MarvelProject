package com.example.myapplication

import com.example.myapplication.model.Characters

data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
){
    fun toCharacter():Characters{
        return Characters(
            id = id,
            name = name,
            description = description,
            thumbnail = thumbnail


        )
    }
}