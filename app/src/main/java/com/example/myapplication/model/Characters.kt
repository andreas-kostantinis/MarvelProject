package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.Thumbnail
import com.google.gson.annotations.SerializedName


@Entity(
    tableName = "Characters"
)
data class Characters(


    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id : Int,

    @ColumnInfo(name= "name")
    @SerializedName("name")
    var name : String,

    @ColumnInfo(name= "desciption")
    @SerializedName("desciption")
    var description : String,


    @ColumnInfo(name = "thumbnail")
    @SerializedName("thumbnail")
    var thumbnail : Thumbnail



)

