package com.example.myapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.Characters


@Dao
interface MarvelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character : Characters)

    @Query("SELECT * FROM characters " )
    suspend fun getFavoriteCharacter() : LiveData<List<Characters>>

    @Delete
    suspend fun deleteCharacter(character : Characters)






}