package com.example.myapplication.api

import com.example.myapplication.MarvelHeroResponses
import com.example.myapplication.model.Characters
import com.example.myapplication.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("v1/public/characters")
    suspend fun getHeroes(

        @Query("offset") offset : Int,
        @Query("limit") limit : Int,
        @Query("apikey") apikey : String = Constants.PUBLIC_API_KEY,
        @Query("ts") ts : String = Constants.ts,
        @Query("hash") hash : String = Constants.hashMd5()
    ) : HeroesService



}