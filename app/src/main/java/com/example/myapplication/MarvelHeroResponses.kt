package com.example.myapplication

import com.google.gson.annotations.SerializedName


data class MarvelHeroResponses(

    @SerializedName("code")
    val code : Int,

    @SerializedName("status")
    val status : String,

    @SerializedName("data")
    val data: Data


)


