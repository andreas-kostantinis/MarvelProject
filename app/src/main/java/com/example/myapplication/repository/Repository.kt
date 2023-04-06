package com.example.myapplication.repository

import com.example.myapplication.api.RetrofitInstance
import com.example.myapplication.db.AppDatabase

class Repository(
    val db : AppDatabase
) {

    suspend fun getHeroes(offset : Int,limit : Int,apikey : String,ts : String,hash : String) =
        RetrofitInstance.api.getHeroes(offset,limit,apikey, ts, hash)
}

