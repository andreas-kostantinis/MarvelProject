package com.example.myapplication.db

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock


@Database(

    entities = [Character:: class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {



    abstract class getDao : MarvelDao

    companion object{

        @Volatile
        private var instance : AppDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context : Context) = instance ?: synchronized(LOCK){

            instance ?: createDatabase(context).also{ instance = it}

        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_db.db"
            ).build()


    }






}